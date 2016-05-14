/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.ListUtils;

/**
 * Value class contain info item validate
 *
 */
public class ItemCheckInfoValue implements Serializable {

    private static final long serialVersionUID = 3769856142306436694L;
    
    /**
     * init object store
     */
    private HashMap<String, List<HashMap<String, Boolean>>> checkList = new HashMap<String, List<HashMap<String, Boolean>>>();

    /**
     * @return checkList
     */
    public HashMap<String, List<HashMap<String, Boolean>>> getCheckList() {
        return checkList;
    }

    /**
     * @param checkList
     */
    public void setCheckList(HashMap<String, List<HashMap<String, Boolean>>> checkList) {
        this.checkList = checkList;
    }
    
    /**
     * get properties of area data
     * @param key
     *      area data
     * @return
     *      object contain properties of area data
     */
    @SuppressWarnings("unchecked")
    public List<HashMap<String, Boolean>> getAreaList(String key) {
        if (checkList.get(key) == null) {
            checkList.put(key, ListUtils.lazyList(new ArrayList<String>(), new ValueFactory(null)));
        }
        return checkList.get(key);
    }

}