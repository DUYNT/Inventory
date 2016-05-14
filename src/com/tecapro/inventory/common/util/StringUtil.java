/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * class String Util
 */
@Component("StringUtil")
public class StringUtil {
    
    private static final String CANDIDATE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";


    @Autowired
    private CheckUtil checkUtil;

    /**
     * Converter Integer to String
     * 
     * @param value
     * @return
     */
    public String toString(Integer value) {
        return toString(value, "");
    }

    /**
     * Converter Integer to String
     * 
     * @param value
     *            Integer
     * @param defaultValue
     *            String
     * @return String
     */
    public String toString(Integer value, String defaultValue) {
        if (null == value) {
            return "" + defaultValue;
        }
        return value.toString();
    }

    /**
     * Converter int to String
     * 
     * @param value
     *            int
     * @param defaultValue
     *            String
     * @return String
     */
    public String toString(int value) {
        return new Integer(value).toString();
    }

    /**
     * Converter long to String
     * 
     * @param value
     *            long
     * @param defaultValue
     *            String
     * @return String
     */
    public String toString(long value) {
        return new Long(value).toString();
    }

    /**
     * Converter Float to String
     * 
     * @param value
     *            int
     * @param defaultValue
     *            String
     * @return String
     */
    public String toString(Float value) {
        if (value == null) {
            return "";
        }
        return value.toString();
    }

    /**
     * Converter Short to String
     * 
     * @param value
     *            Short
     * @param defaultValue
     *            String
     * @return String
     */
    public String toString(Short value, String defaultValue) {
        if (null == value) {
            return "" + defaultValue;
        }
        return value.toString();
    }

    /**
     * Converter String to int
     * 
     * @param value
     *            String
     * @return Int
     */
    public int toInt(String value) {
        if ((null == value) || ("".equals(value)) || (!checkUtil.isNumber(value))) {
            return 0;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Convert Object to String and convert to empty if is null
     * 
     * @author dovietanh
     * @param str
     * @return
     */
    public String convertNull(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    /**
     * @see com.tecapro.inventory.common.util.StringUtil.convertNull(Object obj)
     * @return String
     */
    public String convertNullToString(Object obj) {
        return convertNull(obj);
    }

    /**
     * Check Object is null
     * 
     * @param str
     *            Object
     * @return true Object input is null or length = 0
     */
    public boolean isNull(Object str) {
        return (str == null || str.toString().length() <= 0);
    }

    /**
     * trim String Input
     * 
     * @param str
     * @return String
     */
    public String trimStr(String str) {
        if (str != null) {
            return str.trim();
        }
        return "";
    }

    public String nullToEmptyStr(String target) {
        if (target == null) {
            return "";
        }
        return target;
    }

    /**
     * Escape sqlCommand
     * 
     * @param string
     *            input string
     * @return null if input string is null, escaped string if input string is
     *         not null
     */
    public String escapeSqlCommand(String string) {
        if (string == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '\\':
                    stringBuilder.append("\\\\");
                    break;
                case '%':
                    stringBuilder.append("\\%");
                    break;
                case '_':
                    stringBuilder.append("\\_");
                    break;
                default:
                    stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String trimAndNullable(String strValue) {
        if (strValue != null) {
            strValue = strValue.trim();
        }
        if (strValue == null || "".equals(strValue)) {
            return null;
        }
        return strValue;
    }

    public String replace(String target, String replaceFrom, String replaceTo) {
        int begin;
        int end;
        String checking = new String(target);
        StringBuffer buffer = new StringBuffer();

        while (checking.length() != 0) {
           
            begin = checking.indexOf(replaceFrom);
            if (begin == -1) {
                
                buffer.append(checking);
                checking = "";
            } else {
                
                end = begin + replaceFrom.length();
                
                buffer.append(checking.substring(0, begin));
                
                buffer.append(replaceTo);
                checking = checking.substring(end);
            }
        }

        return buffer.toString();
    }

    /**
     * Calculate the thirteenth digit for membership number or jan code
     * 
     * @param membershipNumber
     *            or jan code
     * @return full membership number or jan code
     */
    public String calculateMembershipNumber(String membershipNumber) {
        final int[] multiple = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3 };
        int sum = 0;
        String result = null;

        if (membershipNumber.length() == multiple.length) {

            for (int i = 0; i < membershipNumber.length(); i++) {
                String c = membershipNumber.substring(i, i + 1);

                int value = Integer.parseInt(c);

                value *= multiple[i];

                sum += value;
            }

            if (sum % 10 == 0) {
                sum = 0;
            } else {
                sum = 10 - sum % 10;
            }

            result = membershipNumber.concat(Integer.toString(sum));
        }

        return result;
    }

    /**
     * Cut String with byte
     * 
     * @param text
     * @param maxBytes
     * @return
     */
    public String cutStringWithByte(String text, int maxBytes) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            // works out how many bytes a character takes,
            // and removes these from the total allowed.
            if ((maxBytes -= text.substring(i, i + 1).getBytes().length) < 0) {
                break;
            }
            ret.append(text.charAt(i));
        }
        return ret.toString();
    }


    /**
     * escape special char in SOLR
     * 
     * @param q
     * @return
     */
    public String escapeSolrKeyword(String q) {
        if (!isNull(q)) {
            String[] es = { "\\", "/", "\"", "(", ")", "{", "}", "[", "]", "-", "+", "OR", "AND", ":", "!", "~", "^" };
            for (int i = 0; i < es.length; i++) {
                q = replace(q, es[i], "\\" + es[i]);
            }
        }
        return q;
    }

    /**
     * generate Random Chars A~Z, 0~9
     * 
     * @param candidateChars
     *            the candidate chars A~Z, 0~9
     * @param length
     *            the number of random chars to be generated
     * 
     * @return
     */
    public String generateRandomChars(String candidateChars, int length) {
        int len  = candidateChars.length();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(len)));
        }

        return sb.toString();
    }

    /**
     * generate Random Chars A~Z, 0~9
     * 
     * @param length
     *            the number of random chars to be generated
     * 
     * @return
     */
    public String generateRandomChars(int length) {
        int len  = CANDIDATE_CHARS.length();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(CANDIDATE_CHARS.charAt(random.nextInt(len)));
        }

        return sb.toString();
    }

    /**
     * generate Random Chars A~Z, 0~9
     * 
     * @return
     */
    public String generateRandomChars() {
        int len  = CANDIDATE_CHARS.length();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(CANDIDATE_CHARS.charAt(random.nextInt(len)));
        }

        return sb.toString();
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
    
    public static String standardizeMobileNumber(String str) {
        if (str == null || str.length() < Constants.MOBILE_NUMBER_MIN_LENGTH
                || str.length() > Constants.MOBILE_NUMBER_MAX_LENGTH) {
            return null;
        }
        
        str = str.trim();
        str = str.replaceAll("\\+", "");
        str = str.replaceAll("-", "");
        str = str.replaceAll("\\(", "");
        str = str.replaceAll("\\)", "");
        str = str.replaceAll(" ", "");
        
        if (str.length() > 0 && "0".equals(str.substring(0, 1))) {
            str = str.substring(1);
        }
        
        if (!isMobileNumber(str)) {
            return null;
        }
        
        String countryCode = str.substring(0, 2);
        
        if (!countryCode.equals("84")) { // have no country code
            str = "84" + str;
        }
        
        return str;
    }
    
    public static boolean isMobileNumber(final CharSequence cs) {
        
        final int seqLength = cs.length();
        
        if (seqLength == 0) {
            return false;
        }
        
        boolean hasMobiPrefix = false;
        char firstChar = cs.charAt(0);
        
        if (cs.charAt(0) == '8' && cs.charAt(1) == '4') { // two first digits are country code
            firstChar = cs.charAt(2);
        }
        
        for (int i = 0; i < Constants.MOBI_PREFIX.length; i ++) {
            if (firstChar == Constants.MOBI_PREFIX[i]) {
                hasMobiPrefix = true;
                break;
            }
        }
        
        if (!hasMobiPrefix) {
            return false;
        }
        
        for (int i = 1; i < seqLength; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isVTNumber(String mobileNumber) {
        
        boolean ret = false;
        
        for (int i = 0; i < Constants.VT_MOBI_PREFIX.length; i ++) {
            int index = mobileNumber.indexOf(Constants.VT_MOBI_PREFIX[i]);
            
            if (index >= 0) {
                ret = true;
                break;
            }
        }
        
        return ret;
    }
    
    public static String decodeHex(String s) {
        String ret = null;
        char[] c = s.toCharArray();
        try {
            byte[] b = Hex.decodeHex(c);
            ret = new String(b, "UTF-8");
        } catch (DecoderException e) {
            ret = s;
        } catch (UnsupportedEncodingException e) {
            ret = s;
        }

        return ret;
    }
    
    public static boolean isEmpty(String s) {
        
        if (s == null || "".equals(s)) {
            return true;
        }
        
        return false;
    }
    
    
}
