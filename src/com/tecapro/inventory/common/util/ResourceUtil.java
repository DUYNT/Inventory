/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

/**
 * Class Resource Util
 *
 */
@Component("ResourceUtil")
public class ResourceUtil {
    
    /**
     * Resource file
     */
    private static final String resource = "appliaction-resources";
    
    /**
     * ResourceBundle object
     */
    private static ResourceBundle bundle = null;
    
    /**
     * contructor
     */
    public ResourceUtil() {
        init();
    }
    
    /**
     * init Resource Bundle
     */
    private void init() {
    	bundle = ResourceBundle.getBundle(resource);
    }
    
    /**
     * get resource String by key
     * 
     * @param key
     *      key in resource message
     * @return
     *      message found
     */
    public String getString(String key) {
        if (bundle == null) {
            init();
        }
        return bundle.getString(key);
    }
}
