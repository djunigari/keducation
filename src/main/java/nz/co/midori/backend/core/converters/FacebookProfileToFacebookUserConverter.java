package nz.co.midori.backend.core.converters;

import nz.co.midori.backend.core.model.FacebookUser;
import org.springframework.social.facebook.api.User;

import java.util.Random;

/**
 * Created by djunigari on 9/06/17.
 */
public class FacebookProfileToFacebookUserConverter {
    public FacebookUser converter(User user){
        FacebookUser facebookUser = new FacebookUser();
        facebookUser.setFacebookId(user.getId());
        facebookUser.setLink(user.getLink());
        facebookUser.setLastName(user.getLastName());
        facebookUser.setFirstName(user.getFirstName());

        if(user.getEmail() == null || user.getEmail().isEmpty()){
            facebookUser.setEmail(user.getId()+"@facebook.com");
        }else{
            facebookUser.setEmail(user.getEmail());
        }
        facebookUser.setPassword(generateString(8));
        facebookUser.setUserName(user.getLink());
        facebookUser.setMobile(user.getLink());
        facebookUser.setGender(user.getGender());

        return facebookUser;
    }

    public static String generateString(int length){
        Random rng = new Random();
        String characters = "qwertyuiopasdfghjklzxcvbnm1234567890AZQXSWCDEVFRBGTNHYMJUIKLOP";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
