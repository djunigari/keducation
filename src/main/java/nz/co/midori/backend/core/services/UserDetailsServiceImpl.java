package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.frontend.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexandreigari on 19/06/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = null;
        user = repository.finUserByEmail(username);
        if(user == null) {
            user = repository.findUserByUserName(username);
        }
        if(user == null){
            throw new UsernameNotFoundException("Task: loadUserByUsername, Result: Failed, ERROR_MESSAGE= User not found");
        }
        return new CustomUserDetails(user);
    }


}
