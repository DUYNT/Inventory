/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * FormatCheckException
 */
public class FormatCheckException extends MSException {

    private static final long serialVersionUID = -8112289242331712613L;

    /**
     * @see com.viettel.common.exception.FileException(String, String[],
     *      Throwable)
     * @param code
     * @param param
     * @param e
     */
    public FormatCheckException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public FormatCheckException(String code, String[] param) {
        super(code, param);
    }

}