/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * ExclusionException
 */
public class ExclusionException extends DBException {

    private static final long serialVersionUID = -8413447353495911841L;

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public ExclusionException(String code, String[] param, Throwable e) {
        super(code, param, e);
        super.setLogOutput(false);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public ExclusionException(String code, String[] param) {
        super(code, param);
        super.setLogOutput(false);
    }

}
