package org.spring.hostel_management_system.Util;

import java.security.SecureRandom;

public class PasswordUtil {

    private static final String CHARACTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@!$";
    private static final int LENGTH=8;
    private static final SecureRandom random=new SecureRandom();
    private PasswordUtil(){}

    public static String generateRandomPassword(){
        StringBuilder password=new StringBuilder(LENGTH);
        for(int i=0;i<LENGTH;i++){
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }


}
