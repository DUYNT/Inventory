/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;


/**
 *  Constants
 *
 */
public class Constants {

    public static final String BLANK = "";

    public static final String SESSION_INFO = "session_info";
    public static final String UPDATE_DATE_TIME_VALUE_SESSION_KEY = "update_date_time_value_session_key";

    public static final String ERRORINFO = "ERRORINFO";

    public static final boolean ERROR_WITH_CODE = false;

    public static final String BACK = "Back";

    public static final String MENU_MODORU = "Back to Menu";
    public static final String RECORD = "Record";
    public static final String SPAGE_FULLSIZE = "　";

    public static final String COMMON_AREA = "common_area";

    public static final String MAX_LIST_COUNT = "MAX_LIST_COUNT";
    public static final String LIST_RECORD_ON_PAGE = "LIST_RECORD_ON_PAGE";
    public static final String DEFAULT_RECORD_ON_PAGE = "DEFAULT_RECORD_ON_PAGE";
    public static final String MAX_RETRY_GET_RECEIPT_NUMBER = "MAX_RETRY_GET_RECEIPT_NUMBER";

    public static final String USER_BATCH = "batch";

    public static final String ZERO = "0";

    public static final String ONE = "1";

    public static final String TWO = "2";

    public static final String ON = "1";

    public static final String OFF = "0";

    public static final String PERIOD = ".";

    public static final String SPACE = " ";

    /**
     * system error code
     */
    public static final String SYSTEM_ERROR_CODE = "MSG079C";
    /**
     * session time out
     */
    public static final String SESSION_TIMEOUT_CODE = "MSG077C";
    
    /**
     * Exclusive error code
     */
    public static final String EXCLUSIVE_CODE = "MSG089C";
    /**
     * Upload file name is empty error code
     */
    public static final String FILE_BLANK_CODE = "MSG080C";
    /**
     * file size equal zero error code
     */
    public static final String FILE_SIZE_ZERO_CODE = "MSG081C";
    /**
     * required error code
     */
    public static final String RIQUIRED_CODE = "MSG022C";
    /**
     * length of string out of rang MIN-MAX error code
     */
    public static final String LENGTH_EQUALS_CODE = "MSG082C";
    /**
     * length of string equals error code
     */
    public static final String OUT_RANGE_CODE = "MSG064C";
    /**
     * format invalid error code
     */
    public static final String FORMAT_INVALID_CODE = "MSG002C";
    /**
     * length of string greater than MAX error code
     */
    public static final String GREATER_THAN_CODE = "MSG010C";
    /**
     * length of string less than MIN error code
     */
    public static final String LESS_THAN_CODE = "MSG085C";
    /**
     * format date invalid error code
     */
    public static final String FORMAT_DATE_CODE = "MSG016C";
    /**
     * number greater than MAX error code
     */
    public static final String NUMBER_MAX_CODE = "MSG083C";
    /**
     * number less than MIN error code
     */
    public static final String NUMBER_MIN_CODE = "MSG084C";
    /**
     * number out of rang MIN-MAX error code
     */
    public static final String NUMBER_MAX_MIN_CODE = "MSG075C";
    /**
     * number invalid error code
     */
    public static final String NUMBER_INVALID_CODE = "MSG086C";
    /**
     * positive part over length error code
     */
    public static final String POSITIVE_CODE = "MSG087C";
    /**
     * decimal part over length error code
     */
    public static final String DECIMAL_CODE = "MSG088C";

    /**
     * request type ajax
     */
    public static final String REQUEST_AJAX = "ajax";

    /**
     * download key: check download after display screen
     */
    public static final String DOWNLOAD_KEY = "download_key";

    /**
     * character ban
     */
    public static final String REPLACE_CHARACTER = "■";
    
    /**
     * Content-type response for AJAX
     */
    public static final String CONTENT_TYPE_AJAX = "application/json";
    
    public static final String PASSWORD_ITEM = "Password";
    
    public static final int MOBILE_NUMBER_MIN_LENGTH = 9;

    public static final int MOBILE_NUMBER_MAX_LENGTH = 12;
    
    public static final char[] MOBI_PREFIX = {'1', '9'};
    
    public static final String[] VT_MOBI_PREFIX = {
        "8496", "8497", "8498", "84163", "84164", "84165", "84166", "84167", "84168", "84169"};
    
    /**
     * Constants of DateFormat
     */
    public static final class DateFormat {

        public static final String HH_MM = "HH:mm";
        public static final String HH_MM_SS = "HH:mm:ss";
        public static final String YYYYMM = "YYYYMM";
        public static final String YYYY_MM = "yyyy/MM";
        public static final String YYYYMMDD = "yyyyMMdd";
        public static final String YYYY_MM_DD = "yyyy/MM/dd";
        public static final String YYYY_MM_DD_ST = "yyyy-MM-dd";
        public static final String YYYY_MM_DD_HH_II_SS_ST = "yyyy-MM-dd HH:mm:ss";
        public static final String YYYY_MM_DD_HH_II_SS_1 = "yyyy/MM/dd HH:mm:ss";
        public static final String YYYY_MM_DD_HH_II_SS_2_ST = "yyyy-MM-dd HH:mm:ss a";
        public static final String YYYY_MM_DD_HH_II_SS_2 = "yyyy/MM/dd HH:mm:ss a";
        public static final String YYYY_MM_DD_HH_II_SS_3 = "yyyyMMddHHmmss";
        public static final String YYYY_MM_DD_HH_II_SS_4 = "yyyyMMddHHmmssa";
    }

    /**
     * Constants of StyleClass
     */
    public static final class StyleClass {

        public static final String REQUIRE = "color_require";

        public static final String READONLY = "color_readonly";

        public static final String ERROR = "color_error";

        public static final String TRANSPARENT = "color_transparent";

    }

    /**
     * Constants of Text encoding
     */
    public static final class Text {

        public static final String APP_ENCODING = "UTF-8";

        public static final String WINDOWS_31J = "WINDOWS-31J";

        public static final String SJIS = "Shift_JIS";

        public static final String UTF_8 = "UTF-8";

        public static final String CRLF = "\r\n";

    }

    /**
     * Constants of Device
     */
    public static final class Device {

        public static final String IS_NORMAL = "IS_NORMAL";
        public static final String IS_MOBILE = "IS_MOBILE";
        public static final String IS_TABLET = "IS_TABLET";

    }
    
    public static final int MSGNO_OK = 0;
    public static final int MSGNO_BAD_REQUEST = 1;
    public static final int MSGNO_EXCEPTION = 2;
}