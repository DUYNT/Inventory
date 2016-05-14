/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * 
 * FileException
 * 
 */
public class FileException extends MSException {

    private static final long serialVersionUID = -7196455049342019141L;

    private String filePath = null;

    /**
     * get path file
     * 
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * set path file
     * 
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @param code
     * @param param
     */
    public FileException(String code, String[] param, Throwable e) {
        super(code, param, e);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @param code
     * @param param
     */
    public FileException(String code, String[] param) {
        super(code, param);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (Throwable)
     * @param code
     * @param param
     */
    public FileException(Throwable cause) {
        super(cause);
    }

}
