package nz.co.midori.backend.core.adapters;

import nz.co.midori.backend.core.model.FacebookUser;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.frontend.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created by alexandreigari on 21/06/17.
 */
@Service
public class FacebookSignInAdapter implements SignInAdapter {
    @Autowired
    private UserRepository repository;

    @Override
    public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
        FacebookUser facebookUser = repository.findByFacebookId(connection.fetchUserProfile().getId());
        CustomUserDetails user = new CustomUserDetails(facebookUser);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user, null,user.getAuthorities()));

        return null;
    }
}

