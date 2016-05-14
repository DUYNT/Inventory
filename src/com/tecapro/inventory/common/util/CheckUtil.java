/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Check Util class
 *
 */
@Component("CheckUtil")
public class CheckUtil {
    
    @Autowired
    private ConvertUtil convertUtil;

    public static final String NOTPERMIT_CHAR = "㎜㎝㎞㎎㎏㏄㎡" + "℡∮∑∟⊿";

    /**
     * is number
     * 
     * @param str
     * @return Number：TRUE, Not number: FALSE
     */
    public boolean isNumber(String str) {

        if (!isDouble(str)) {
            return false;
        }

        // Not a Number
        if (str.equals("NaN")) {
            return false;
        }

        return true;
    }
    
    /**
     * Check string is Numeric
     * @param input
     * @return
     *      true if is Numeric, null or blank
     */
    public boolean isNumeric(String input) {
        if (input == null && !"".equals(input)) {
            return true;
        }
        Pattern p = Pattern.compile("^[0-9]+$");
        Matcher m = p.matcher(input);

        return m.find();
    }


    /**
     * is email address
     * 
     * @param mailAddr
     *            
     */
    public boolean isMailAddr(String mailAddr) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(mailAddr);
    }

    /**
     * Have not permit character
     * 
     * @param text
     */
    public boolean haveKinshiMoji(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (NOTPERMIT_CHAR.indexOf(text.charAt(i)) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * check Date with format yyyy-MM-dd
     * @param date
     * @return
     */
    public boolean isDateValid(String date) {
        Boolean ret = false;
        try {
            String[] ary;
            if (!"".equals(date)) {
                ary = date.split("-", 3);
                ret = isDate(Integer.parseInt(ary[0]), Integer.parseInt(ary[1]), Integer.parseInt(ary[2]));
            }
        } catch (NumberFormatException e) {
            ret = false;
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }

    public boolean isDateFormat(String target, SimpleDateFormat formatter) {
        java.util.Date parseDate;
        try {
            parseDate = formatter.parse(target);
        } catch (ParseException e) {
            return false;
        }

        if (!target.equals(formatter.format(parseDate))) {
            return false;
        }
        return true;
    }

    public boolean isDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.set(year, month - 1, day);
        try {
            cal.getTime();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean isDate(String year, String month, String day) {
        return isDate(convertUtil.getValueOfInt(year), convertUtil.getValueOfInt(month), convertUtil.getValueOfInt(day));
    }

    public boolean isDouble(String value) {
        if (value == null) {
            return false;
        }
        try {
            new Double(convertUtil.trim(value)).doubleValue();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
