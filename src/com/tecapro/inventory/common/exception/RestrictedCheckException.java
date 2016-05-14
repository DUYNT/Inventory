/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * RestrictedCheck
 */
public class RestrictedCheckException extends MSException {

    private static final long serialVersionUID = 8798086856134594378L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @param code
     * @param param
     */
    public RestrictedCheckException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public RestrictedCheckException(String code, String[] param) {
        super(code, param);
    }

}
