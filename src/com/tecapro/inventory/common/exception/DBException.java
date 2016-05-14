/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

/**
 * DBException
 */
public class DBException extends MSException {

    private static final long serialVersionUID = -3683398442760099736L;

    /**
     * SQL String
     */
    private String sql = null;

    /**
     * get SQL String
     * 
     * @return
     */
    public String getSql() {
        return sql;
    }

    /**
     * set SQL string
     * 
     * @param sql
     */
    public void setSql(String sql) {
        this.sql = sql;
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[],
     *      Throwable)
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public DBException(String code, String[] param, Throwable e) {
        super(code, param, e);
        super.setLogOutput(true);
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException (String, String[])
     * @see com.viettel.common.exception.CSSException .setLogOutput(boolean)
     * @param code
     * @param param
     */
    public DBException(String code, String[] param) {
        super(code, param);
        super.setLogOutput(true);
    }

}