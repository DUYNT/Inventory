/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * Unique
 */
public class UniqueKeyException extends DBException {

    private static final long serialVersionUID = -3435648941760357297L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @param code
     * @param param
     */
    public UniqueKeyException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public UniqueKeyException(String code, String[] param) {
        super(code, param);
    }

}
