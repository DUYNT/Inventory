/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.html.NestedTextareaTag;

import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * TextArea custom tag
 *
 */
public class MSTextAreaTag extends NestedTextareaTag {

    private static final long serialVersionUID = 9067002438807635658L;
    
    private boolean require = false;
    private String area = null;

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int doStartTag() throws JspException {

        if (getDisabled()) {
            setReadonly(true);
            setDisabled(false);
        }

        TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);

        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

        tilesValue.setInfo(form.getValue().getInfo());

        StringBuffer onFocus = new StringBuffer();

        if (getOnfocus() != null) {
            onFocus.append(getOnfocus() + ";");
        }

        HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
        keyMap.put(getProperty(), isRequire());
        area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
        form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);

        StringBuffer colorClass = new StringBuffer();

        if (isRequire()) {
            colorClass.append(Constants.StyleClass.REQUIRE);
            colorClass.append(Constants.SPACE);
        }

        if (getReadonly()) {
            colorClass.append(Constants.StyleClass.READONLY);
            colorClass.append(Constants.SPACE);
        }

        List<String> idList = form.getError().getIdList();

        for (String id : idList) {
            if (id.equals(getProperty())) {
                colorClass.append(Constants.StyleClass.ERROR);
                colorClass.append(Constants.SPACE);
                break;
            }
        }

        if (tilesValue.isReadonly()) {
            colorClass = new StringBuffer(Constants.StyleClass.READONLY);
            setReadonly(true);
        }

        if (colorClass.length() > 0) {
            MSTagUtil.addStyleClass(this, colorClass.toString());
        }

        onFocus.append("textSelect(this);");
        setOnfocus(onFocus.toString());

        MSTagUtil.setChangeFlag(this);

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            this.require = false;
            this.area = null;
            this.setStyleClass(null);
            this.setOnchange(null);
            this.setOnfocus(null);
        }
    }

    @Override
    protected String renderData() throws JspException {
        String data = super.renderData();

        if (data != null && Constants.SPACE.equals(data)) {
            return "";
        }

        return MSTagUtil.replaceInvalidCharcter(data, Constants.REPLACE_CHARACTER);
    }

}