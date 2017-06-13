package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Created by djunigari on 10/05/17.
 */
@Service
public class UserService {
    private Logger log = Logger.getLogger("UserService");

    public static final String KEY_ACTIVATE_USE = "89312";
    public static final String KEY_RESET_PASSWORD_USER = "312312";

    @Autowired
    private UserRepository repository;
    @Autowired
    private MailSender sender;

    public void createUser(ApplicationUser user) throws UnsupportedEncodingException {
        log.info("Task: Creating User, User:"+user.toString());
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
