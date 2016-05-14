/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.CommonUtil;

/**
 * ValueBase64 tag
 * @see com.tecapro.inventory.common.tag.MSHiddenTag
 *
 */
public class MSValueBase64Tag extends MSHiddenTag {
    
    private static final long serialVersionUID = -4078847764905421484L;
    
    private static final String BEAN_NAME_COMMON_UTIL = "CommonUtil";

    @Override
    public int doStartTag() throws JspException {

        try {
            
            CommonUtil commonUtil = (CommonUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_COMMON_UTIL);
            BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

            form.setValueBase64(new String(commonUtil.serialize(form.getValue())));

            setProperty("valueBase64");

            return super.doStartTag();
        } catch (Exception e) {
            throw new JspException(e);
        }
    }

}
