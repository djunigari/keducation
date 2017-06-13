package nz.co.midori.backend.core.services;

import nz.co.midori.backend.core.model.User;
import nz.co.midori.backend.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by djunigari on 10/05/17.
 */
@Service
public class UserAuthentication {
    private Logger log = Logger.getLogger("UserAuthentication");
    @Autowired
    private UserRepository repository;

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

    public boolean activateUserAccount(User user){
        String email = user.getEmail();
        log.info("Task: Activating User, Email= "+email);
        user = repository.finUserByEmail(email);
        if(user == null){
            log.info("Task: Activate User, Result: Failed, Error: Email={"+email+"} does not exist");
            return false;
        }
        user.setActivated(true);
        repository.updateUser(user);
        log.info("Task: Activate User, Result: Success, User: "+user.toString());
        return true;
    }
}
