/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.nested.NestedPropertyHelper;
import org.apache.struts.taglib.nested.html.NestedCheckboxTag;

import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * CheckBox custom tag
 *
 */
public class MSCheckBoxTag extends NestedCheckboxTag {

    private static final long serialVersionUID = 3327553318475043320L;
    
    /* the usual private member variables */
    private String originalName = null;
    private String originalProperty = null;
    private String offValue = "";
    private String area = null;
    private boolean require = false;

    public String getOffValue() {
        return offValue;
    }

    public void setOffValue(String offValue) {
        this.offValue = offValue;
    }

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

    @SuppressWarnings("deprecation")
    @Override
    public int doStartTag() throws JspException {
        TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);

        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

        tilesValue.setInfo(form.getValue().getInfo());

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

        MSTagUtil.setChangeFlag(this);

        // get the original properties
        originalName = getName();
        originalProperty = getProperty();

        // request
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        // set the properties
        NestedPropertyHelper.setNestedProperties(request, this);

        StringBuffer onClick = new StringBuffer();

        onClick.append("clickCheckBox(this,'").append(getValue()).append("','").append(offValue).append("','").append(prepareName()).append("');");

        if (getOnclick() != null) {
            onClick.append(getOnclick());
        }

        setOnclick(onClick.toString());

        // Create an appropriate "input" element based on our parameters
        StringBuffer results = new StringBuffer("<input type=\"checkbox\"");

        prepareAttribute(results, "accesskey", getAccesskey());
        prepareAttribute(results, "tabindex", getTabindex());

        prepareAttribute(results, "value", getValue());

        if (isChecked()) {
            results.append(" checked=\"checked\"");
        }

        if (tilesValue.isReadonly()) {
            prepareAttribute(results, "disabled", "true");
        }

        results.append(prepareEventHandlers());
        results.append(prepareStyles());
        prepareOtherAttributes(results);
        results.append(getElementClose());

        // Print this field to our output writer
        TagUtils.getInstance().write(pageContext, results.toString());

        // Continue processing this page
        this.text = null;

        MSHiddenTag hiddenTag = new MSHiddenTag(false);
        hiddenTag.setPageContext(pageContext);
        if (isChecked()) {
            hiddenTag.setValue(getValue());
        } else {
            hiddenTag.setValue(getOffValue());
        }
        hiddenTag.setParent(this);
        hiddenTag.setName(getName());
        hiddenTag.setProperty(getProperty());
        hiddenTag.doStartTag();
        hiddenTag.doEndTag();

        return (EVAL_BODY_TAG);

    }

    @Override
    public int doEndTag() throws JspException {
        try {

            // Render any description for this checkbox
            if (text != null) {
                TagUtils.getInstance().write(pageContext, text);
            }

            // Evaluate the remainder of this page

            // reset the properties
            setName(originalName);
            setProperty(originalProperty);

            return EVAL_PAGE;

        } finally {
            this.require = false;
            this.setStyleClass(null);
            this.setOnchange(null);
            this.setOnclick(null);
            originalName = null;
            originalProperty = null;
            this.area = null;
        }
    }

}
