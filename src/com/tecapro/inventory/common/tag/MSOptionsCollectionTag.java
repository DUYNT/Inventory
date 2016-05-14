/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.nested.html.NestedOptionsCollectionTag;

/**
 * OptionsCollection custom tag
 *
 */
public class MSOptionsCollectionTag extends NestedOptionsCollectionTag {

    private static final long serialVersionUID = 5198334542038950923L;

    @Override
    public int doStartTag() throws JspException {

        try {
            return super.doStartTag();
        } catch (Exception e) {
            throw new JspException(e);
        }
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            this.name = null;
            this.property = null;
            this.setLabel(null);
            this.setValue(null);
        }
    }

}
