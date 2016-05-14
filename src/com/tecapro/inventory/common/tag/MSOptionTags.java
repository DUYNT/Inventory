/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.html.OptionTag;

/**
 * Option custom tag
 *
 */
public class MSOptionTags extends OptionTag {

    private static final long serialVersionUID = -8931462747609911804L;

    @Override
    public int doStartTag() throws JspException {
        try {
            return super.doStartTag();
        } catch (Exception e) {
            throw new JspException(e);
        }
    }
}
