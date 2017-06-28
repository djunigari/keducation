package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.FacebookUser;
import nz.co.midori.backend.core.model.UserRole;
import nz.co.midori.backend.core.model.UserRoleType;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static nz.co.midori.backend.core.utils.StringUtil.generateString;

/**
 * Created by alexandreigari on 21/06/17.
 */
@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository roleRepository;
    @Autowired
    private Facebook facebook;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public String execute(Connection<?> connection) {
        FacebookUser user = userRepository.findByFacebookId(connection.fetchUserProfile().getId());
        if(userRepository.findByFacebookId(connection.fetchUserProfile().getId()) != null){
            return user.getUserName();
        }

        user = new FacebookUser();
        user.setUserName(connection.getDisplayName());
        user.setFacebookId(connection.fetchUserProfile().getId());
        user.setLink(connection.getProfileUrl());
        user.setPassword(generateString(8));
        UserRole role = roleRepository.findByName(UserRoleType.Normal.toString());
        Set<UserRole> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.createFacebookUser(user);
        return user.getUserName();
    }
}
