/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

/**
 * Convert Util class
 *
 */
@Component("ConvertUtil")
public class ConvertUtil {
    
    private static final char[] SJIS = {
            0x00a5, // ＼
            0x2014, // ―
            0x301c, // ～
            0x2016, // ∥
            0x2212, // －
            0x00a2, // ￠
            0x00a3, // ￡
            0x00ac, // ￢
    };

    private static final char[] MS932 = { 0x005c, 0x2015, 0xff5e, 0x2225, 0xff0d, 0xffe0, 0xffe1, 0xffe2, };


    public String trim(String string) {

        if (string == null) {
            return "";
        }

        int length;
        String trimString = string.trim();
        if ((length = trimString.length()) == 0) {
            return "";
        }

        int top, tail;

        for (top = 0; top < length; top++) {
            if (trimString.charAt(top) != '　') {
                break;
            }
        }

        if (!(top < length)) {
            return "";
        }

        for (tail = length - 1; tail >= 0; tail--) {
            if (trimString.charAt(tail) != '　') {
                break;
            }
        }

        if ((top != 0) || (tail != (length - 1))) {
            trimString = trimString.substring(top, tail + 1);
        }

        return trimString;
    }

    public int getValueOfInt(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return new Integer(trim(value)).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public long getValueOfLong(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return new Long(trim(value)).longValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public double getValueOfDouble(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return new Double(trim(value)).doubleValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String convert(String target) {
        if (target == null) {
            return null;
        }

        char[] buf = target.toCharArray();
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < SJIS.length; j++) {
                if (buf[i] == SJIS[j]) {
                    buf[i] = MS932[j];
                    break;
                }
            }
        }
        return new String(buf);
    }

    public String stringCutterUseByte(String target, int length) {
        if (target == null) {
            return target;
        }
        byte[] targetArray;
        try {
            targetArray = target.getBytes(Constants.Text.APP_ENCODING);
        } catch (UnsupportedEncodingException e) {
            targetArray = target.getBytes();
        }
        if (length < 0 || length > targetArray.length) {
            return target;
        }
        char[] charArray = target.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            byte[] current;
            try {
                current = Character.toString(charArray[i]).getBytes(Constants.Text.APP_ENCODING);
            } catch (UnsupportedEncodingException e) {
                current = Character.toString(charArray[i]).getBytes();
            }
            length -= current.length;
            if (length >= 0) {
                sb.append(charArray[i]);
            } else {
                break;
            }
        }
        return sb.toString();
    }

}