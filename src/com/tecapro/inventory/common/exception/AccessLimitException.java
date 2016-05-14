/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * AccessLimit
 */
public class AccessLimitException extends MSException {

    private static final long serialVersionUID = -4021855282707337041L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public AccessLimitException(String code, String[] param, Throwable e) {
        super(code, param, e);
        super.setLogOutput(true);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public AccessLimitException(String code, String[] param) {
        super(code, param);
        super.setLogOutput(true);
    }

}
