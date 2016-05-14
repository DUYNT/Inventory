/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.nested.html.NestedPasswordTag;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.ItemPropertyUtil;

/**
 * Password custom tag
 *
 */
public class MSPasswordTag extends NestedPasswordTag {

    private static final long serialVersionUID = 6884679168492690926L;
    private static final String BEAN_NAME_ITEM_PROP_UTIL = "ItemPropertyUtil";
    
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
        
        ItemPropertyUtil itemPropUtil = (ItemPropertyUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_ITEM_PROP_UTIL);
        
        TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);
        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

        tilesValue.setInfo(form.getValue().getInfo());

        ItemValidationInfoValue itemValue = itemPropUtil.getItemInfo(getProperty());

        StringBuffer onFocus = new StringBuffer();

        if (getOnfocus() != null) {
            onFocus.append(getOnfocus() + ";");
        }

        if (itemValue != null) {

            if (itemValue.isKana() || itemValue.isFullwidth()) {
                MSTagUtil.addStyleClass(this, "imeonoff");
                onFocus.append("imeOn();");
            } else {
                MSTagUtil.addStyleClass(this, "imeoff");
            }
        }

        HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
        keyMap.put(getProperty(), isRequire());
        area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
        form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);

        String colorClass = null;

        if (isRequire()) {
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

        if (tilesValue.isReadonly()) {
            setReadonly(true);
        }

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
            this.setOnchange(null);
            this.setOnfocus(null);
            this.setStyleClass(null);

        }
    }

}
