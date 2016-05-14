package com.tecapro.inventory.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

public class PasswordUtil {
    
    public static String generateRandomString(int stringLength) {
        
        //Store character for generate string
        String str01 = "abcdefghijklmnopqrstuvwxyz";
        String str02 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str03 = "0123456789";
        
        //Store string to generate
        String strValid = str01 + str02 + str03;
        
        String stringRamdom = "";
        
        Random random = new Random();
        
        for (int i = 0; i < stringLength; i++) {
            int randnum = random.nextInt(strValid.length()); 
            stringRamdom = stringRamdom + strValid.charAt(randnum);
        }
        
        return stringRamdom;
    }

    /**
     * Get hash string from password and salt
     * In addition, username can be used to make hash string more complicated
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public static String hashPassword(String username, String password, String salt) {
        if (salt == null) {
            salt = "";
        }
        
        //String str = username + password + salt;
        String str = password + salt;
        
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            
            byte[] passBytes = str.getBytes();
            byte[] passHash = sha256.digest(passBytes);
            char[] charHash = Hex.encodeHex(passHash);
            str = new String(charHash);
        } catch (NoSuchAlgorithmException e) {
            // Do nothing
        }
        
        return str;
    }
}
