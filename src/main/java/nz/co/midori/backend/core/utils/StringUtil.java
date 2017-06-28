package nz.co.midori.backend.core.utils;

import java.util.Random;

/**
 * Created by alexandreigari on 29/06/17.
 */
public class StringUtil {
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
