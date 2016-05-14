/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.html.NestedFileTag;

import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * File custom tag
 *
 */
public class MSFileTag extends NestedFileTag {
    
    private static final long serialVersionUID = 8912413438942656306L;
    
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

        String colorClass = null;

        if (require) {
            colorClass = Constants.StyleClass.REQUIRE;
        }

        List<String> idList = form.getError().getIdList();

        for (String id : idList) {
            if (id.equals(getProperty())) {
                colorClass = Constants.StyleClass.ERROR;
                break;
            }
        }

        if (colorClass != null) {
            MSTagUtil.addStyleClass(this, colorClass);
        }

        onFocus.append("textSelect(this);");
        setOnfocus(onFocus.toString());

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            this.require = false;
            this.setStyleClass(null);
            this.setOnfocus(null);
            this.area = null;
        }
    }

}
