/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * class Date Util
 */
@Component("DateUtil")
public class DateUtil {

    public static final String FORMAT_YEAR_MONTH = "yyyyMM";
    public static final String FORMAT_YEAR_MONTH_SLASH = "yyyy/MM";
    public static final String FORMAT_YEAR_MONTH_DAY = "yyyyMMdd";
    public static final String FORMAT_YEAR_MONTH_DAY_SLASH = "yyyy/MM/dd";
    public static final String FORMAT_YEAR_MONTH_DAY_HOUR = "yyyyMMddHH";
    public static final String FORMAT_YEAR_MONTH_DAY_HOUR_SLASH = "yyyy/MM/dd HH";
    public static final String FORMAT_YEAR_MONTH_DAY_HOUR_MIN = "yyyyMMddHHmm";
    public static final String FORMAT_YEAR_MONTH_DAY_SLASH_TIME = "yyyy/MM/dd HH:mm";
    public static final String FORMAT_YEAR_MONTH_DAY_DOT_TIME = "yyyy.MM.dd HH:mm";
    public static final String FORMAT_YEAR_MONTH_DAY_SEC = "yyyyMMddHHmmss";
    public static final String FORMAT_YEAR_MONTH_DAY_SEC_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMAT_HOUR_MINUTE_SECOND = "HH:mm:ss";
    public static final String FORMAT_HOUR_MINUTE = "HH:mm";
    public static final String FORMAT_YEAR_MONTH_DAY_FULL_TIME = "yyyyMMddHHmmss";
    public static final String FORMAT_MONTH_DAY_SLASH = "MM/dd";
    public static final String YEAR_MONTH_DAY = "yyMMdd";
    public static final String JAPANESE_FORMAT = "yyyy年MM月dd日";
    public static final String JAPANESE_FORMAT_SHORT = "yyyy年MM月";
    public static final String FORMAT_YEAR_MONTH_DAY_HYPHEN = "yyyy-MM-dd";
    public static final String FORMAT_DAY_MONTH_YEAR_HYPHEN = "dd/MM/yyyy";
    public static final String FORMAT_YEAR_MONTH_DAY_SEC_HYPHEN = "yyyy-MM-dd HH:mm:ss";
    // Add format date print PDF
    public static final String JAPANESE_FORMAT_MM_DD = "MM月dd日";
    public static final String JAPANESE_FORMAT_DD = "dd日";

    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMMDDHHMMSSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDDHHMMSSS = new SimpleDateFormat("yyyyMMddHHmmssS");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD_HHMMSSS = new SimpleDateFormat("yyyyMMdd HHmmssS");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD_HHMMSS = new SimpleDateFormat("yyyyMMdd HHmmss");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMMDDHHMM = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDDHHMM = new SimpleDateFormat("yyyyMMddHHmm");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD_HHMM = new SimpleDateFormat("yyyyMMdd HHmm");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMMDD = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMD_JA = new SimpleDateFormat("yyyy年M月d日");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_YYYYMM = new SimpleDateFormat("yyyy/MM");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYMM = new SimpleDateFormat("yyyyMM");
    public static final SimpleDateFormat DATE_FORMATTER_YYYYM_JA = new SimpleDateFormat("yyyy年M月");
    public static final SimpleDateFormat DATE_FORMATTER_YYYY = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_MD = new SimpleDateFormat("M/d");
    public static final SimpleDateFormat DATE_FORMATTER_MMDD = new SimpleDateFormat("MMdd");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_MD_JA = new SimpleDateFormat("M月d日");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_HHMM = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat DATE_FORMATTER_HHMM = new SimpleDateFormat("HHmm");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_HHMMSS = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMATTER_SEPARATED_HHMMSSS = new SimpleDateFormat("HH:mm:ss.S");
    public static final SimpleDateFormat DATE_FORMATTER_HHMMSSS = new SimpleDateFormat("HHmmssS");
    public static final SimpleDateFormat DATE_FORMATTER_CONVERTABLE_TO_TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
    public static final SimpleDateFormat DATE_FORMATTER_YYMMDDHHMMSS = new SimpleDateFormat("yyMMddhhmmss");
    public static final SimpleDateFormat DATE_FORMATTER_HHMMSS = new SimpleDateFormat("HHmmss");

    /**
     * instance of StringUtil
     */
    @Autowired
    private StringUtil strUtil;

    /**
     * Convert Date to String
     *
     * @author
     * @param date
     * @param format
     * @return String
     */
    public String convertDateToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
        return mySimpleDateFormat.format(date);
    }

    /**
     * Convert Date to String
     * 
     * @author
     * @param date
     * @param format
     * @return String
     * @author nguyentruonggiang
     */
    public Integer convertDateToInt(String date) {
        String input = deleteExceptNum(date);
        if (strUtil.isNull(input)) {
            return null;
        }
        return strUtil.toInt(input);
    }

    /**
     * convert Timestamp to Date
     *
     * @author
     * @param stamp
     * @return Date
     */
    public Date toDate(Timestamp stamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(stamp);
        return cal.getTime();
    }

    /**
     * Convert string to date with any format
     *
     * @author
     * @param strDate
     * @param format
     *            date format
     * @return date object
     */
    public Date toDate(String strDate, String format) {
        Date result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.parse(strDate);
        } catch (ParseException e) {
            result = null;
        }
        return result;
    }

    public Date toDate(String strDate) {
        String cmpStr;
        cmpStr = deleteExceptNum(strDate);
        Date rtnDate;

        if (cmpStr.length() == 14) {
            // yyyyMMddHHmmss
            rtnDate = toDate(cmpStr, FORMAT_YEAR_MONTH_DAY_FULL_TIME);
        } else if (cmpStr.length() == 12) {
            // yyyyMMddHHmm
            rtnDate = toDate(cmpStr, FORMAT_YEAR_MONTH_DAY_HOUR_MIN);
        } else if (cmpStr.length() == 10) {
            // yyyyMMddHH
            rtnDate = toDate(cmpStr, FORMAT_YEAR_MONTH_DAY_HOUR);
        } else if (cmpStr.length() == 8) {
            // yyyyMMdd
            rtnDate = toDate(cmpStr, FORMAT_YEAR_MONTH_DAY);
        } else if (cmpStr.length() == 6) {
            // yyyyMM
            rtnDate = toDate(cmpStr, FORMAT_YEAR_MONTH);
        } else {
            rtnDate = null;
        }

        return rtnDate;
    }

    public String deleteSlash(String target) {
        String rtnStr = target;
        rtnStr = strUtil.replace(rtnStr, "/", "");
        rtnStr = strUtil.replace(rtnStr, "／", "");
        return rtnStr;
    }

    public String deleteColon(String target) {
        String rtnStr = target;
        rtnStr = strUtil.replace(rtnStr, ":", "");
        rtnStr = strUtil.replace(rtnStr, "：", "");
        return rtnStr;
    }

    public String deleteHyphen(String target) {
        String rtnStr = target;
        rtnStr = strUtil.replace(rtnStr, "-", "");
        rtnStr = strUtil.replace(rtnStr, "－", "");
        return rtnStr;
    }

    public String deleteSpace(String target) {
        String rtnStr = target;
        rtnStr = strUtil.replace(rtnStr, " ", "");
        rtnStr = strUtil.replace(rtnStr, "　", "");
        return rtnStr;
    }

    public String deleteComma(String target) {
        String rtnStr = target;
        rtnStr = strUtil.replace(rtnStr, ".", "");
        rtnStr = strUtil.replace(rtnStr, "．", "");
        return rtnStr;
    }

    public String deleteExceptNum(String target) {
        String rtnStr = target;
        if (!strUtil.isNull(target)) {
            rtnStr = deleteSlash(rtnStr);
            rtnStr = deleteColon(rtnStr);
            rtnStr = deleteHyphen(rtnStr);
            rtnStr = deleteSpace(rtnStr);
            rtnStr = deleteComma(rtnStr);
        }

        return rtnStr;
    }

    /**
     * Calculate previouse YM from YM formated string.
     *
     * @param ym
     * @return
     * @throws ParseException
     * @author
     */
    public String calcPreviousYm(String ym) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date date = convertYearMonthToDate(ym);
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return toYearMonth(cal.getTime());
    }

    /**
     * Convert string ym to java date class.
     *
     * @param ym
     * @return java.util.Date
     * @throws ParseException
     * @author
     */
    public Date convertYearMonthToDate(String ym) throws ParseException {
        // Calendar cal = Calendar.getInstance();
        String format = ym.length() == 6 ? FORMAT_YEAR_MONTH : FORMAT_YEAR_MONTH_DAY;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        return sdf.parse(ym);
    }

    /**
     * format specified Date to '201005' template
     *
     * @author
     * @param date
     *            specified Date
     * @return String formated Date in String ('201005')
     */
    public String toYearMonth(Date date) {
        String result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YEAR_MONTH);
            result = sdf.format(date);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    /**
     * format date to japanese style
     *
     * @param date
     * @param shortFormat
     * @return formatted date String
     */
    public String toJapaneseDate(Date date, boolean shortFormat) {
        String result = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(shortFormat ? JAPANESE_FORMAT_SHORT : JAPANESE_FORMAT);
            result = sdf.format(date);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    public java.sql.Timestamp createSqlTimestamp() {
        return new java.sql.Timestamp(new Date().getTime());
    }

    public String getCurrentDate() {
        return DATE_FORMATTER_YYYYMMDD.format(new Date());
    }

    public String getCurrentTime() {
        return DATE_FORMATTER_HHMMSS.format(new Date());
    }

    public String getCurrentDate(SimpleDateFormat formatter) {
        return formatter.format(new Date());
    }

    /**
     * add Month to Date
     *
     * @author
     * @param date
     *            date
     * @param addMonth
     *            addMonth
     * @return Date after add month
     */
    public Date addMonthYmd(Date date, int addMonth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, addMonth);
        return cal.getTime();
    }

    /**
     * get Day of Month
     *
     * @param date
     * @return day
     */
    public int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get Day Of Week with Locale.JAPANESE
     *
     * @author
     * @param yM
     *            year month
     * @param day
     *            day of year month
     * @return day of week
     */
    public String getDayOfWeek(String yyyyMMdd) {
        Date date = toDate(yyyyMMdd, FORMAT_YEAR_MONTH_DAY);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.JAPANESE);
        return sdf.format(date);
    }

    /**
     * get Day Of Week with Locale.JAPANESE
     *
     * @author
     * @param yM
     *            year month
     * @param day
     *            day of year month
     * @return day of week
     */
    public String getDayOfWeek(String yyyyMMdd, String dateFormat) {
        Date date = toDate(yyyyMMdd, dateFormat);
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.JAPANESE);
        return sdf.format(date);
    }

    /**
     * get Day Of Week with Locale.JAPANESE
     *
     * Get date of week
     *
     * @return String
     */
    public String getDayOfWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.JAPANESE);
        return sdf.format(date);
    }

    /**
     * get Day Of Week with Locale.JAPANESE
     *
     * Get date of week
     *
     * @return String
     */
    public String getDayOfWeek(Date date, boolean isCheckNull) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("E", Locale.JAPANESE);
        return sdf.format(date);
    }

    /**
     * get next date
     *
     * @param tempDate
     *            : tempDate
     * @param reStartTime
     *            : is restart time
     * @return next date
     */
    public Date getNextDate(Date tempDate, boolean reStartTime) {
        if (tempDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tempDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        if (reStartTime) {
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        return cal.getTime();
    }

    /**
     * get previous date
     *
     * @param tempDate
     *            : tempDate
     * @return next date
     */
    public Date getPrevDate(Date tempDate, boolean resetTime) {
        if (tempDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tempDate);
        if (resetTime) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        return cal.getTime();
    }

    /**
     * Get total days of month with date param
     *
     * @author
     * @param date
     *            Date object
     * @return total days of month
     */
    public int getTotalDaysOfMonth(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * add Year to Date
     * @param date
     * @param addYear
     * @return Date after add year
     */
    public Date addYearYmd(Date date, int addYear) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (addYear > 0) {
            cal.add(Calendar.YEAR, addYear);
        }
        return cal.getTime();
    }

    /**
     * add Day to Date
     * 
     * @param date
     * @param addDay
     * @return Date after add year
     */
    public Date addDayYmd(Date date, int addDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (addDay > 0) {
            cal.add(Calendar.DAY_OF_MONTH, addDay);
        }
        return cal.getTime();
    }

    /**
     * Get date by last day of the month
     *
     * @param date Date object
     * @return Date by last day of the month, if date param invalid then return null
     */
    public static Date getDateByLastDayOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Calendar calResult = Calendar.getInstance();
        calResult.set(Calendar.HOUR_OF_DAY, 0);
        calResult.set(Calendar.MINUTE, 0);
        calResult.set(Calendar.SECOND, 0);
        calResult.set(Calendar.MILLISECOND, 0);
        calResult.set(Calendar.YEAR, cal.get(Calendar.YEAR));
        calResult.set(Calendar.MONTH, cal.get(Calendar.MONTH));
        calResult.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calResult.getTime();
    }
    public static String getCurrentDateTime() {
        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        
        return currentTime;
    }
}
