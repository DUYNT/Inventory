/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.exception;

import java.util.ArrayList;
import java.util.List;

public class MSException extends Exception {

    private static final long serialVersionUID = 1807674658648168694L;

    /**
     * ERR Code
     */
    private String code = null;
    /**
     * Error item property
     */
    private List<String> idList = new ArrayList<String>();
    /**
     * Error item param
     */
    private String[] param = null;
    
    private boolean resetData = true;
    
    private boolean logOutput = false;

    private String result = null;

    /**
     * get result string
     * 
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     * set result string
     * 
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @param cause
     */
    public MSException(Throwable cause) {
        super(cause);
        resetData = true;
    }

    /**
     * init attribute code and param
     * 
     * @param code
     * @param param
     */
    public MSException(String code, String[] param) {
        this.code = code;
        this.param = param;
        resetData = true;
    }

    /**
     * @see com.tecapro.inventory.common.exception.MSException.MSException (String
     *      code, String[] param, Throwable e, boolean resetData)
     * @param code
     * @param param
     * @param e
     */
    public MSException(String code, String[] param, Throwable e) {
        this(code, param, e, true);
    }

    /**
     * init attribute code, param, resetData
     * 
     * @param code
     * @param param
     * @param e
     * @param resetData
     */
    public MSException(String code, String[] param, Throwable e, boolean resetData) {
        super(e);
        this.code = code;
        this.param = param;
        this.resetData = resetData;
    }

    /**
     * get exception code
     * 
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the idList
     */
    public List<String> getIdList() {
        return idList;
    }

    /**
     * @param idList
     *            the idList to set
     */
    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    /**
     * Set Error ID
     * 
     * @param errorId
     */
    public void setErrorId(String errorId) {
        this.idList.add(errorId);
    }

    /**
     * get error parameter
     * 
     * @return
     */
    public String[] getParam() {
        return param;
    }

    /**
     * get reset data flag
     * 
     * @return
     */
    public boolean isResetData() {
        return resetData;
    }

    /**
     * set error code
     * 
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * set error parameter
     * 
     * @param param
     */
    public void setParam(String[] param) {
        this.param = param;
    }

    /**
     * set reset data flag
     * 
     * @param resetData
     */
    public void setResetData(boolean resetData) {
        this.resetData = resetData;
    }

    /**
     * get value of attribute logOutput
     * 
     * @return
     */
    public boolean isLogOutput() {
        return logOutput;
    }

    /**
     * set value of attribute logOutput
     * 
     * @param logOutput
     */
    public void setLogOutput(boolean logOutput) {
        this.logOutput = logOutput;
    }

}