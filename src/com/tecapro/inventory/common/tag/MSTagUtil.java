/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseHandlerTag;
import org.apache.struts.taglib.html.CheckboxTag;
import org.apache.struts.taglib.html.RadioTag;

import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * Util taglib
 *
 */
public class MSTagUtil {

    /**
     * add style class
     * 
     * @param tag
     * @param styleClass
     */
    public static void addStyleClass(BaseHandlerTag tag, String styleClass) {
        if (tag.getStyleClass() != null) {
            tag.setStyleClass(new StringBuffer().append(tag.getStyleClass()).append(" ").append(styleClass).toString());
        } else {
            tag.setStyleClass(styleClass);
        }
    }

    /**
     * add style。
     * 
     * @param tag
     * @param styleClass
     */
    public static void addStyle(BaseHandlerTag tag, String style) {
        if (tag.getStyle() != null) {
            tag.setStyle(new StringBuffer().append(tag.getStyle()).append(" ").append(style).toString());
        } else {
            tag.setStyle(style);
        }
    }

    /**
     * Replace invalid character
     * 
     * @param input
     * @param replace
     * @return
     */
    public static String replaceInvalidCharcter(String input, String replace) {
        return input;
    }

    /**
     * set change flag
     * 
     * @param tag
     */
    public static void setChangeFlag(BaseHandlerTag tag) {
        String change = "changeFlag(this);";
        if (tag instanceof CheckboxTag || tag instanceof RadioTag) {
            change += tag.getOnclick() != null ? tag.getOnclick() : "";
            tag.setOnclick(change);
        } else {
            change += tag.getOnchange() != null ? tag.getOnchange() : "";
            tag.setOnchange(change);
        }
    }
    
    /**
     * lookup data in Base Form
     * 
     * @param numSeisu
     * @param pageContext
     * @param name
     * @param property
     * @return
     */
    public static Object getOrgValue(Integer numSeisu, PageContext pageContext, String name, String property) {
        String[] vals = null;
        Object val = null;
        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());
        
        if (form.getProperties().size() > 0 && form.getErrorFlag()) {
            vals = (String[]) form.getProperties().get(name);
    
            if (vals != null && vals.length > 0) {
                val = vals[0];
            }
        }
        
        if (val == null || "".equals(val)) {
            Object value;
            try {
                value = TagUtils.getInstance().lookup(pageContext, "BaseForm", property, null);
            } catch (JspException e) {
                value = Constants.BLANK;
            }
            if (value != null) {
                //val = value.toString();
                val = value;
            } else {
                val = Constants.BLANK;
            }
            if (numSeisu != null && (val.toString()).indexOf(".") != -1) {
                val = (val.toString()).replaceAll("[0]+$", "").replaceAll("\\.$", "");
            }
        } else if (numSeisu != null) {
            val = (val.toString()).replaceAll(",", "").replaceAll("¥", "");
        }
        return val;
    }
}