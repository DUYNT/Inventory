/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.html.LinkTag;

/**
 * Link custom tag
 *
 */
public class MSLinkTag extends LinkTag {
    
    private static final long serialVersionUID = -4450916789756150403L;

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
        } catch (Exception e) {
            throw new JspException(e);
        }
    }
}
