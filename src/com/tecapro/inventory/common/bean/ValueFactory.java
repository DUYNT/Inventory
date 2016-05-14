/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;

import org.apache.commons.collections.Factory;

public class ValueFactory implements Serializable, Factory {
    
    private static final long serialVersionUID = -3350812431869917074L;
    
    private Class<? extends Object> clazz = null;

    /**
     * ValueFactory constructor
     * 
     * @param clazz
     */
    public ValueFactory(Class<? extends Object> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * new instance object
     */
    public Object create() {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
