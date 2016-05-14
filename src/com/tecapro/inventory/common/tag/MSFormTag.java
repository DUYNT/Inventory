/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.nested.html.NestedFormTag;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.form.BaseForm;

/**
 * Form custom tag
 *
 */
public class MSFormTag extends NestedFormTag {

    private static final long serialVersionUID = 3526093112326987616L;

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            target = null;
        }
    }

    @Override
    public int doStartTag() throws JspException {
        InfoValueIF value = (InfoValueIF) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName() + "_Value");
        BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());
        form.setValue(value);
        this.setTarget(null);
        return super.doStartTag();
    }

}
