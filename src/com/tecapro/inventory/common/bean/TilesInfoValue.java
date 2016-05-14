/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.tecapro.inventory.common.InfoValueIF;

/**
 * Value class contain info layout
 *
 */
public class TilesInfoValue implements InfoValueIF, Serializable {
    
    private static final long serialVersionUID = 6244230743593363027L;

    /**
     * object info value
     */
    private InfoValue info = new InfoValue();

    /**
     * tile of page
     */
    private String title = null;

    /**
     * base target for HTML page
     */
    private String target = null;

    /**
     * subTilte of page
     */
    private String subTitle = "";

    /**
     * setting up readonly all item on page
     */
    private boolean readonly = false;
    
    /**
     * page id
     */
    private String id = null;
    
    /**
     * object ButtonInfoValue contain button info
     */
    @SuppressWarnings("unchecked")
    private List<ButtonInfoValue> buttonList = (List<ButtonInfoValue>) ListUtils.lazyList(new ArrayList<ButtonInfoValue>(), new ValueFactory(
            ButtonInfoValue.class));

    public InfoValue getInfo() {
        return info;
    }

    public void setInfo(InfoValue info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ButtonInfoValue> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<ButtonInfoValue> buttonList) {
        this.buttonList = buttonList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

   
}