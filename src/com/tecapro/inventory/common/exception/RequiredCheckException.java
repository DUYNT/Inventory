/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * RequiredCheck
 */
public class RequiredCheckException extends MSException {

    private static final long serialVersionUID = 7560615102221681934L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @param code
     * @param param
     */
    public RequiredCheckException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public RequiredCheckException(String code, String[] param) {
        super(code, param);
    }

}
