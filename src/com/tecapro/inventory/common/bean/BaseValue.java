/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;

import com.tecapro.inventory.common.InfoValueIF;

public abstract class BaseValue implements InfoValueIF, Serializable {
    
    private static final long serialVersionUID = 6782626016192096389L;

    /* Instance of UserValue */
    private InfoValue info = null;
    
    /* Contain json data */
    private Object jsonData = null;
    
    @Override
    public InfoValue getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(InfoValue infoBean) {
        this.info = infoBean;
    }

    /**
     * @return the jsonData
     */
    public Object getJsonData() {
        return jsonData;
    }

    /**
     * @param jsonData the jsonData to set
     */
    public void setJsonData(Object jsonData) {
        this.jsonData = jsonData;
    }
   
   
}
