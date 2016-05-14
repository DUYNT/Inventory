/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.exception.FormatCheckException;
import com.tecapro.inventory.common.exception.InputCheckException;
import com.tecapro.inventory.common.exception.RequiredCheckException;

/**
 * Item check util class
 *
 */
@Component("ItemCheckUtil")
public class ItemCheckUtil {

    private static final int BYTE_OF_CHAR = 3;

    private static final String MINDATEINPUT_PROPERTIES_KEY = "MINDATEINPUT_PROPERTIES";

    private static final String MAXDATEINPUT_PROPERTIES_KEY = "MAXDATEINPUT_PROPERTIES";

    private static List<String> MINDATEINPUT_PROPERTIES;

    private static List<String> MAXDATEINPUT_PROPERTIES;

    @Autowired
    private CheckUtil checkUtil;
    
    @Autowired
    private CommonUtil commonUtil;

    /**
     * init attribute
     */
    public void init() {
        
        String[] props = null;

        props = commonUtil.getValue(MINDATEINPUT_PROPERTIES_KEY).split(",");
        MINDATEINPUT_PROPERTIES = new ArrayList<String>(props.length);
        for (int i = 0; i < props.length; i++) {
            MINDATEINPUT_PROPERTIES.add(props[i]);
        }
        props = commonUtil.getValue(MAXDATEINPUT_PROPERTIES_KEY).split(",");
        MAXDATEINPUT_PROPERTIES = new ArrayList<String>(props.length);
        for (int i = 0; i < props.length; i++) {
            MAXDATEINPUT_PROPERTIES.add(props[i]);
        }
    }

    public void checkItem(ItemValidationInfoValue param, String item, String property) 
                    throws InputCheckException, FormatCheckException, Exception {

        String[] errMsg = null;

        String strCheck = "";

        if (param.isAlph()) {
            strCheck = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }

        if (param.isNum()) {
            strCheck += "0123456789";
        }

        if (param.isCode()) {
            strCheck += "!#$%&'()*+,-ｰ./:;<=>?@[]^_`{|}~｡｢｣､･ " + "'\\'" + '"';
        }

        if (param.isKana()) {
            strCheck += "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝﾞﾟｧｨｩｪｫｬｭｮｯ";
        }
        
        String itemSJIS = "";
        try {
            itemSJIS = new String(item.getBytes(Constants.Text.WINDOWS_31J), Constants.Text.WINDOWS_31J);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        
        for (int i = 0; i < item.length(); i++) {
            char strMoji = item.charAt(i);
            char cSJIS = itemSJIS.charAt(i);

            boolean hanteiFlag = !Constants.BLANK.equals(strCheck) || param.isFullwidth();

            if (!Constants.BLANK.equals(strCheck)) {

                strCheck += "\r\n";

                if (strCheck.indexOf(strMoji) >= 0) {
                    hanteiFlag = false;

                } else {
                    hanteiFlag = true;
                }
            }

            if (hanteiFlag && param.isFullwidth()) {
                try {
                    if (Character.toString(cSJIS).getBytes(Constants.Text.WINDOWS_31J).length >= 2) {
                        hanteiFlag = false;
                    } else {
                        hanteiFlag = true;
                    }
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }

            if (hanteiFlag) {
                String strMessage = "";

                if (param.isAlph()) {
                    strMessage += "Single-byte alphabetic characters";
                }

                if (param.isNum()) {
                    if (!Constants.BLANK.equals(strMessage)) {
                        strMessage += ", Byte numbers";
                    } else {
                        strMessage += "Byte numbers";
                    }
                }
                if (param.isCode()) {
                    if (!Constants.BLANK.equals(strMessage)) {
                        strMessage += ", Single-byte symbol";
                    } else {
                        strMessage += "Single-byte symbol";
                    }
                }

                if (param.isKana()) {
                    if (!Constants.BLANK.equals(strMessage)) {
                        strMessage += ", Half-width Kana";
                    } else {
                        strMessage += "Half-width Kana";
                    }
                }

                if (param.isFullwidth()) {
                    if (!Constants.BLANK.equals(strMessage)) {
                        strMessage += ", Full-width Kana";
                    } else {
                        strMessage += "Full-width Kana";
                    }
                }
                errMsg = new String[] { property, strMessage };
                FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getLengthMax() != null && param.getLengthMin() != null) {
            String strKeta = "";

            for (int j = 0; j < item.length(); j++) {
                if (isByteCheckContainChara(item.charAt(j), param)) {
                    strKeta += item.charAt(j);
                }
            }
            
            if (strKeta.length() > param.getLengthMax() || strKeta.length() < param.getLengthMin()) {
                String min = "";
                String max = "";
                if (param.getLengthMax() == param.getLengthMin()) {
                    if (param.isKana() || param.isFullwidth() || (!param.isAlph() && !param.isCode() && !param.isNum())) {
                        max = Long.valueOf((param.getLengthMax() / BYTE_OF_CHAR)).toString();
                    } else {
                        max = param.getLengthMax().toString(); 
                    }
                    FormatCheckException ex = new FormatCheckException(Constants.LENGTH_EQUALS_CODE, new String[] { property, max });
                    ex.setErrorId(property);
                    throw ex;
                } else {
                    if (param.isKana() || param.isFullwidth() || (!param.isAlph() && !param.isCode() && !param.isNum())) {
                        min = Long.valueOf((param.getLengthMin() / BYTE_OF_CHAR)).toString();
                        max = Long.valueOf((param.getLengthMax() / BYTE_OF_CHAR)).toString();
                    } else {
                        min = param.getLengthMin().toString();
                        max = param.getLengthMax().toString();
                    }
                    FormatCheckException ex = new FormatCheckException(Constants.OUT_RANGE_CODE, new String[] { property, min, max });
                    ex.setErrorId(property);
                    throw ex;
                    
                }
            }
        }

        if (param.getLengthMax() != null) {
            String strMaxKeta = "";

            for (int j = 0; j < item.length(); j++) {
                if (isByteCheckContainChara(item.charAt(j), param)) {
                    strMaxKeta += item.charAt(j);
                }
            }
            
            if (strMaxKeta.length() > param.getLengthMax()) {
                String num = "";
                if (param.isKana() || param.isFullwidth() || (!param.isAlph() && !param.isCode() && !param.isNum())) {
                    num = Long.valueOf((param.getLengthMax() / BYTE_OF_CHAR)).toString();
                } else {
                    num = param.getLengthMax().toString();
                }
                FormatCheckException ex = new FormatCheckException(Constants.GREATER_THAN_CODE, new String[] { property, num });
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getLengthMin() != null) {
            String strMinKeta = "";

            for (int k = 0; k < item.length(); k++) {
                if (isByteCheckContainChara(item.charAt(k), param)) {
                    strMinKeta += item.charAt(k);
                }
            }

            if (strMinKeta.length() < param.getLengthMin()) {
                String num = "";
                if (param.isKana() || param.isFullwidth() || (!param.isAlph() && !param.isCode() && !param.isNum())) {
                    num = Long.valueOf((param.getLengthMin() / BYTE_OF_CHAR)).toString();
                } else {
                    num = param.getLengthMin().toString();
                }
                FormatCheckException ex = new FormatCheckException(Constants.LESS_THAN_CODE, new String[] { property, num });
                ex.setErrorId(property);
                throw ex;
            }
        }

        BigDecimal numItem = null;

        if (param.getNumSeisuLength() != null) {
            String strSuchi = "";
            for (int n = 0; n < item.length(); n++) {
                if (item.charAt(n) != ',') {
                    strSuchi += item.charAt(n);
                }
            }

            try {
                numItem = new BigDecimal(strSuchi);

                if (strSuchi.contains("+")) {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                FormatCheckException ex = new FormatCheckException(Constants.NUMBER_INVALID_CODE, new String[] { property });
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getNumSeisuLength() != null) {
            String strSeisuKeta = "";
            String seisu = numItem.toBigInteger().toString();

            for (int m = 0; m < seisu.length(); m++) {
                if (seisu.charAt(m) != '-') {
                    strSeisuKeta += seisu.charAt(m);
                }
            }

            if (strSeisuKeta.length() > param.getNumSeisuLength()) {
                errMsg = new String[] { property, param.getNumSeisuLength().toString() };
                FormatCheckException ex = new FormatCheckException(Constants.POSITIVE_CODE, errMsg);
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getNumShosuLength() != null) {
            String[] shosu = null;
            if (item.indexOf(Constants.PERIOD) != -1) {
                shosu = numItem.toString().split("\\.");

                if (shosu.length != 2 || shosu[1].length() > param.getNumShosuLength()) {
                    errMsg = new String[] { property, param.getNumShosuLength().toString() };
                    FormatCheckException ex = new FormatCheckException(Constants.DECIMAL_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            }
        }

        if (param.getNumMax() != null && param.getNumMin() != null) {
            if (param.getNumMax().compareTo(numItem) < 0 || param.getNumMin().compareTo(numItem) > 0) {
                errMsg = new String[] { property, param.getNumMin().toString(), param.getNumMax().toString() };
                FormatCheckException ex = new FormatCheckException(Constants.NUMBER_MAX_MIN_CODE, errMsg);
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getNumMax() != null) {
            if (param.getNumMax().compareTo(numItem) < 0) {
                errMsg = new String[] { property, param.getNumMax().toString() };
                FormatCheckException ex = new FormatCheckException(Constants.NUMBER_MAX_CODE, errMsg);
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getNumMin() != null) {
            if (param.getNumMin().compareTo(numItem) > 0) {
                errMsg = new String[] { property, param.getNumMin().toString() };
                FormatCheckException ex = new FormatCheckException(Constants.NUMBER_MIN_CODE, errMsg);
                ex.setErrorId(property);
                throw ex;
            }
        }

        if (param.getFormat() != null && !Constants.BLANK.equals(param.getFormat())) {
            boolean hizukeErrFlag = false;
            boolean formatErrFlag = false;

            if (param.getFormat().equals(Constants.DateFormat.YYYY_MM_DD) || param.getFormat().equals(Constants.DateFormat.YYYY_MM)) {

                item = item.replaceAll("-", "/");
                String strSuchi = "0123456789/";
                for (int l = 0; l < item.length(); l++) {
                    if (strSuchi.indexOf(item.charAt(l)) == -1) {
                        hizukeErrFlag = true;
                        continue;
                    }
                }

                if (!hizukeErrFlag) {
                    String[] date = null;

                    if (param.getFormat().equals(Constants.DateFormat.YYYY_MM_DD)) {

                        if (item.indexOf("/") != -1) {
                            date = item.split("/");

                            if (date.length != 3) {
                                formatErrFlag = true;

                            } else if (date[0].length() != 4 || date[1].length() != 2 || date[2].length() != 2) {

                                formatErrFlag = true;

                            } else if (!checkUtil.isDate(date[0], date[1], date[2])) {
                                hizukeErrFlag = true;

                                if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("0000".equals(date[0]) && "00".equals(date[1]) && "00".equals(date[2])) {
                                        hizukeErrFlag = false;
                                    }
                                    
                                } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("9999".equals(date[0]) && "99".equals(date[1]) && "99".equals(date[2])) {
                                        hizukeErrFlag = false;
                                    }
                                }
                            }

                        } else if ((item.indexOf("/") == -1) && (item.length() == 8)) {

                            if (item.substring(4, 6).length() != 2 || item.substring(6, 8).length() != 2) {
                                formatErrFlag = true;

                            } else if (!checkUtil.isDate(item.substring(0, 4), item.substring(4, 6), item.substring(6, 8))) {
                                hizukeErrFlag = true;

                                if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("00000000".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                    
                                } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("99999999".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                }
                            }

                        } else {
                            formatErrFlag = true;
                        }

                        if (formatErrFlag) {
                            errMsg = new String[] { property, "YYYYMMDD、YYYY/MM/DD" };

                        } else if (hizukeErrFlag) {
                            errMsg = new String[] { property, "正しい日付" };
                        }

                    } else {
                        if (item.indexOf("/") != -1) {

                            date = item.split("/");

                            if (date.length != 2) {
                                formatErrFlag = true;

                            } else if (date[0].length() != 4 || date[1].length() != 2) {
                                formatErrFlag = true;

                            } else if (Integer.valueOf(date[1]) < 1 || Integer.valueOf(date[1]) > 12) {
                                hizukeErrFlag = true;

                                if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("0000/00".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("9999/99".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                }
                            }

                        } else if ((item.indexOf("/") == -1) && (item.length() == 6)) {

                            if (item.substring(4, 6).length() != 2) {
                                formatErrFlag = true;

                            } else if (Integer.valueOf(item.substring(4, 6)) < 1 || Integer.valueOf(item.substring(4, 6)) > 12) {
                                hizukeErrFlag = true;

                                if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("000000".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                    
                                } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                                    if ("999999".equals(item)) {
                                        hizukeErrFlag = false;
                                    }
                                }
                            }

                        } else {
                            formatErrFlag = true;
                        }

                        if (formatErrFlag) {
                            errMsg = new String[] { property, "YYYYMM、YYYY/MM" };

                        } else if (hizukeErrFlag) {
                            errMsg = new String[] { property, "Correct date" };
                        }
                    }

                    if (formatErrFlag) {
                        FormatCheckException ex = new FormatCheckException(Constants.FORMAT_DATE_CODE, errMsg);
                        ex.setErrorId(property);
                        throw ex;

                    } else if (hizukeErrFlag) {
                        FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                        ex.setErrorId(property);
                        throw ex;
                    }

                } else {
                    errMsg = new String[] { property, "Correct date" };
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            } else if (param.getFormat().equals(Constants.DateFormat.YYYYMMDD)) {

                errMsg = new String[] { property, "Correct date" };
                if (item.length() != 8) {
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
                String strSuchi = "0123456789";
                for (int l = 0; l < item.length(); l++) {
                    if (strSuchi.indexOf(item.charAt(l)) == -1) {
                        FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                        ex.setErrorId(property);
                        throw ex;
                    }
                }
                hizukeErrFlag = false;
                if (!checkUtil.isDate(item.substring(0, 4), item.substring(4, 6), item.substring(6, 8))) {
                    hizukeErrFlag = true;

                    if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                        if ("00000000".equals(item)) {
                            hizukeErrFlag = false;
                        }
                        
                    } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                        if ("99999999".equals(item)) {
                            hizukeErrFlag = false;
                        }
                    }
                }
                if (hizukeErrFlag) {
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }

            } else if (param.getFormat().equals(Constants.DateFormat.YYYYMM)) {

                errMsg = new String[] { property, "Correct years" };
                if (item.length() != 6) {
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
                String strSuchi = "0123456789";
                for (int l = 0; l < item.length(); l++) {
                    if (strSuchi.indexOf(item.charAt(l)) == -1) {
                        FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                        ex.setErrorId(property);
                        throw ex;
                    }
                }
                hizukeErrFlag = false;
                if (!checkUtil.isDate(item.substring(0, 4), item.substring(4, 6), "1")) {
                    hizukeErrFlag = true;
                    if (MINDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                        if ("000000".equals(item)) {
                            hizukeErrFlag = false;
                        }
                        
                    } else if (MAXDATEINPUT_PROPERTIES.contains(param.getProperty())) {
                        if ("999999".equals(item)) {
                            hizukeErrFlag = false;
                        }
                    }
                }
                if (hizukeErrFlag) {
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }

            } else if ("mail".equals(param.getFormat())) {
                if (!checkUtil.isMailAddr(item)) {
                    errMsg = new String[] { property, "Correct e-mail address" };
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            } else if (Constants.DateFormat.HH_MM.equals(param.getFormat())) {

                boolean result = item.matches("[0-2][0-9]:*[0-5][0-9]");

                if (result) {
                    String hhmm = item.length() == "hh:mm".length() ? item.replace(":", "") : item;

                    if ((hhmm.substring(0, 2).compareTo("24") >= 0) || (hhmm.substring(2, 4).compareTo("60") >= 0)) {
                        result = false;
                    }
                }

                if (!result) {
                    errMsg = new String[] { property, "Correct time" };
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            }  else if (Constants.DateFormat.HH_MM_SS.equals(param.getFormat())) {

                boolean result = item.matches("[0-2][0-9]:*[0-5][0-9]:*[0-5][0-9]");

                if (result) {
                    String hhmm = item.length() == "hh:mm:ss".length() ? item.replace(":", "") : item;

                    if ((hhmm.substring(0, 2).compareTo("24") >= 0) 
                                    || (hhmm.substring(2, 4).compareTo("60") >= 0) 
                                    || (hhmm.substring(4, 6).compareTo("60") >= 0)) {
                        result = false;
                    }
                }

                if (!result) {
                    errMsg = new String[] { property, "Correct time" };
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            } else if (Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1.equals(param.getFormat())
                    || Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2.equals(param.getFormat())
                    || Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3.equals(param.getFormat())
                    || Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4.equals(param.getFormat())) {
                SimpleDateFormat formatter = new SimpleDateFormat(param.getFormat());
                try {
                    item = item.replaceAll("-", "/");
                    formatter.parse(item);
                } catch (ParseException e) {
                    errMsg = new String[] { property, "Correct date" };
                    FormatCheckException ex = new FormatCheckException(Constants.FORMAT_INVALID_CODE, errMsg);
                    ex.setErrorId(property);
                    throw ex;
                }
            }
        }
    }

    protected boolean isByteCheckContainChara(char data, ItemValidationInfoValue param) {

        if (Constants.DateFormat.YYYY_MM_DD.equals(param.getFormat()) || Constants.DateFormat.YYYY_MM.equals(param.getFormat())) {
            return data != '/';
        } else if (Constants.DateFormat.HH_MM.equals(param.getFormat())) {
            return data != ':';
        } else if (param.getNumShosuLength() != null || param.getNumSeisuLength() != null) {
            return data != '.' && data != ',';
        }

        return true;
    }

    /**
     * requred check
     * 
     * @param inputValue
     * @param property
     * @throws RequiredCheckException
     */
    public void checkRequired(String inputValue, String property) throws RequiredCheckException {

        boolean error = true;

        if (inputValue != null) {
            error = inputValue.length() == 0;
        }

        if (error) {
            RequiredCheckException ex = new RequiredCheckException(Constants.RIQUIRED_CODE, new String[] { property });
            ex.setErrorId(property);
            throw ex;
        }
    }

}