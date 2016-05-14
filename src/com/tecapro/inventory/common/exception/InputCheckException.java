/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

public class InputCheckException extends MSException {

    private static final long serialVersionUID = 1920098082744310558L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @param code
     * @param param
     * @param e
     */
    public InputCheckException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public InputCheckException(String code, String[] param) {
        super(code, param);
    }

}