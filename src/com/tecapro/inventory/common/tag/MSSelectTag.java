/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.html.NestedSelectTag;

import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * Select custom tag
 *
 */
public class MSSelectTag extends NestedSelectTag {

    /** default serial */
    private static final long serialVersionUID = -3797106354865816224L;
    
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

        StringBuffer colorClass = new StringBuffer();

        HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
        keyMap.put(getProperty(), isRequire());
        area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
        form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);

        if (isRequire()) {
            colorClass.append(Constants.StyleClass.REQUIRE);
            colorClass.append(Constants.SPACE);
        }

        if (getDisabled() || getReadonly()) {
            colorClass.append(Constants.StyleClass.READONLY);
            colorClass.append(Constants.SPACE);
        }

        MSTagUtil.setChangeFlag(this);

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
            setDisabled(true);
        }

        if (colorClass.length() > 0) {
            MSTagUtil.addStyleClass(this, colorClass.toString());
        }

        String onClick = getOnclick() != null ? getOnclick() : "";

        setOnmousedown(onClick + ";");

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            require = false;
            this.area = null;
            this.setOnchange(null);
            this.setStyleClass(null);
            this.setDisabled(false);
            this.setValue(null);
            this.setOnfocus(null);
            this.setOnchange(null);
            this.setOnmousedown(null);
            this.setOnmouseup(null);

        }
    }

    public void setMatch(String value) {
        this.match = new String[] { value };
    }
}
