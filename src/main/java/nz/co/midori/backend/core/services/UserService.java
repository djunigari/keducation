package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.model.UserRole;
import nz.co.midori.backend.core.model.UserRoleType;
import nz.co.midori.backend.core.repositories.UserRepository;
import nz.co.midori.backend.core.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by djunigari on 10/05/17.
 */
@Service
public class UserService {
    private Logger log = Logger.getLogger("UserService");
    @Autowired
    private UserRoleRepository roleRepository;

    @Value("${app.security.crypto.key_activate_user}")
    public String KEY_ACTIVATE_USE;
    @Value("${app.security.crypto.key_reset_password_user}")
    public String KEY_RESET_PASSWORD_USER;

    @Autowired
    private UserRepository repository;
    @Autowired
    private MailSender sender;

    public void createUser(ApplicationUser user) throws UnsupportedEncodingException {
        log.info("Task: Creating User, User:"+user.toString());
        UserRole role = roleRepository.findByName(UserRoleType.Normal.toString());
        Set<UserRole> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        repository.createUser(user);
        String token = String.format("%x", new BigInteger(1, user.getEmail().getBytes("UTF-8")));
        token = token+"_"+getCodeToken(token,KEY_ACTIVATE_USE);
        sender.authenticationEmail(user.getEmail(),user.getUserName(),token);
        log.info("Task: Create User, Result: Success, User:"+user.toString());
    }

    public String getCodeToken(String token,String key){
        String code = "";
        for(int i = 0; i < token.length(); i++){
            code+= Character.getNumericValue(token.charAt(i));
        }
        return new BigInteger(code).multiply(new BigInteger(key)).toString();
    }

    public void forgottenPassword(ApplicationUser user) throws UnsupportedEncodingException {
        String token = String.format("%x", new BigInteger(1, user.getUserName().getBytes("UTF-8")));
        token = token+"_"+getCodeToken(token,KEY_RESET_PASSWORD_USER);
        sender.forgettenPassword(user.getEmail(),user.getUserName(),token);
    }
}
