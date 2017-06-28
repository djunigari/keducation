package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.exceptions.ForbiddenException;
import nz.co.midori.backend.core.exceptions.ResourceNotFoundException;
import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.repositories.UserRepository;
import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * Created by djunigari on 10/05/17.
 */
@Service
public class UserAuthentication {
    private Logger log = Logger.getLogger("UserAuthentication");

    @Value("${app.security.crypto.key_activate_user}")
    public String KEY_ACTIVATE_USE;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    public boolean authenticateUserByEmailAndPassword(String email, String password){
        User user = repository.finUserByEmailAndPassword(email,password);
        if(user == null){
            return false;
        }
        return true;

    }
    public boolean authenticateUserByUserNameAndToken(String userName, String token){
        User user = repository.findUserByUserNameAndToken(userName,token);
        if(user == null){
            return false;
        }
        return true;
    }

    public void activateUserAccount(long id, String code) throws UnsupportedEncodingException, DecoderException {
        User user = service.getUserByCode(code,KEY_ACTIVATE_USE);
        if(user == null){
            throw new ResourceNotFoundException();
        }
        if(user.getUserId() != id){
            throw new ForbiddenException();
        }

        user.setActivated(true);
        repository.updateUser(user);
        log.info("Task: Activate User, Result: Success, User: "+user);
    }


}
