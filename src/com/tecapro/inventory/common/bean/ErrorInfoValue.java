/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Value class contain info error
 * 
 */
public class ErrorInfoValue implements Serializable {

    private static final long serialVersionUID = -5591079715290808216L;

    private String errorId = null;
    /**
     * error message
     */
    private String errorMessage = null;

    private List<String> idList = new ArrayList<String>();

    /**
     * get errorMessage
     * 
     * @return errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * set errorMessage
     * 
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorId() {
        return this.errorId;
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
        this.errorId = (this.idList != null && this.idList.size() > 0 ? this.idList.get(0) : null);
    }

}