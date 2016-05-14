/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.action;

import com.tecapro.inventory.common.bean.TilesInfoValue;

/**
 * Tiles action class
 *
 */
public class TilesLayoutAction extends DelegateAction {

    /**
     * TilesInfoValue object
     */
    private TilesInfoValue value = null;

    /**
     * get value
     * @return value
     */
    public TilesInfoValue getValue() {
        return value;
    }

    /**
     * set value
     * @param value
     */
    public void setValue(TilesInfoValue value) {
        this.value = value;
    }

    /**
     * method logic for tile request
     * @return
     *      "success" always
     * @throws Exception
     */
    public String init() throws Throwable {
        return "success";
    }

}
