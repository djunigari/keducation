package nz.co.midori.backend.core.validators;

import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.backend.core.model.School;
import nz.co.midori.backend.core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by alexandreigari on 27/06/17.
 */
public class ApplicationUserValidator implements Validator {
    @Autowired
    private UserRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return School.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApplicationUser user = (ApplicationUser)o;

        if(repository.finUserByEmail(user.getEmail()) != null){
            errors.rejectValue("email","message.user.email.exist");
        }
        if(repository.findUserByUserName(user.getUserName()) != null){
            errors.rejectValue("userName","message.user.userName.exist");
        }
        if(!user.getPasswordConfirmation().equals(user.getPassword())){
            errors.rejectValue("passwordConfirmation","message.user.passwordConfirmation.different");
        }
    }
}
