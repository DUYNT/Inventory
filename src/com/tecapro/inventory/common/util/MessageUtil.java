/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.bean.ValueFactory;

/**
 * MessageUtil class
 *
 */
@Component("MessageUtil")
@Scope("request")
public class MessageUtil {
    
    /**
     * instance of PropertiesUtil
     */
    @Autowired
    private PropertiesUtil propUtil;
    
    @SuppressWarnings("unchecked")
    private List<Throwable> errorList = ListUtils.lazyList(new ArrayList<Throwable>(), new ValueFactory(null));
    
    /**
     * get error list
     * 
     * @return List<Throwable>
     */
    public List<Throwable> getErrorList() {
        return errorList;
    }

    /**
     * clear error list
     */
    public void resetErrorList() {
        errorList.clear();
    }

    /**
     * set error
     * 
     * @param e
     */
    public void setError(Throwable e) {
        errorList.add(e);
        
    }

    /**
     * get error message
     * 
     * @param messageCode
     * @param params
     * @return
     */
    public String getMessage(String messageCode) {
        String messageFormat = propUtil.getMsgProperty(messageCode);
        if (Constants.ERROR_WITH_CODE) {
            return getMessageWithCode(messageCode, messageFormat, new String[] {});
        } else {
            return getMessageNoCode(messageFormat, new String[] {});
        }
    }

    /**
     * get error message
     * 
     * @param messageCode
     * @param params
     * @return
     */
    public String getMessage(String messageCode, String[] params) {
        params = processParams(params);
        String messageFormat = propUtil.getMsgProperty(messageCode);
        if (Constants.ERROR_WITH_CODE) {
            return getMessageWithCode(messageCode, messageFormat, params);
        } else {
            return getMessageNoCode(messageFormat, params);
        }
    }
    
    /**
     * get message without message code
     * 
     * @param messageCode
     * @param params
     * @return
     */
    public String getMessageWithoutCode(String messageCode, String[] params) {
        params = processParams(params);
        String messageFormat = propUtil.getMsgProperty(messageCode);
        return getMessageNoCode(messageFormat, params);
    }
    
    /**
     * Process parameter
     * 
     * @param params
     * @return
     */
    private String[] processParams(String[] params) {
        if (params != null && params.length > 0) {
            String itemName = null;
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    params[i] = (params[i].indexOf("value.") != -1) ? params[i].substring(params[i].lastIndexOf(".") + 1) : params[i];
                    itemName = propUtil.getItemProperty(params[i]);
                    if (itemName != null) {
                        params[i] = itemName;
                    }
                }
            }
        }
        return params;
    }
    
    /**
     * get error message with error code
     * @param messageCode
     * @param messageFormat
     * @param params
     * @return
     */
    private String getMessageWithCode(String messageCode, String messageFormat, String[] params) {
        return new StringBuffer().append(messageCode).append(" ").append(MessageFormat.format(messageFormat, (Object[]) params)).toString();
    }

    /**
     * get error message no error code
     * 
     * @param messageFormat
     * @param params
     * @return
     */
    private String getMessageNoCode(String messageFormat, String[] params) {
        return new StringBuffer().append(MessageFormat.format(messageFormat, (Object[]) params)).toString();
    }
}
