/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.struts.taglib.html.MessagesTag;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.util.MessageUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * Message custom tag
 * 
 */
public class MSMsgTag extends MessagesTag {

    private static final long serialVersionUID = -251258107200308205L;

    private static final String BEAN_NAME_MSG_UTIL = "MessageUtil";
    private static final String BEAN_NAME_STRING_UTIL = "StringUtil";

    private String msgCode;
    private String params;
    private String style;
    private boolean withCode = true;
    private boolean filter = true;
    private String styleClass;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @return the withCode
     */
    public boolean isWithCode() {
        return withCode;
    }

    /**
     * @param withCode
     *            the withCode to set
     */
    public void setWithCode(boolean withCode) {
        this.withCode = withCode;
    }

    /**
     * @return the filter
     */
    public boolean isFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {

        String msg = null;
        MessageUtil msgUtil = (MessageUtil) WebApplicationContextUtils.getWebApplicationContext(
                        pageContext.getServletContext()).getBean(BEAN_NAME_MSG_UTIL);
        StringUtil strUtil = (StringUtil) WebApplicationContextUtils.getWebApplicationContext(
                        pageContext.getServletContext()).getBean(BEAN_NAME_STRING_UTIL);

        if (this.msgCode != null && !"".equals(this.msgCode)) {
            String[] p = new String[] {};
            if (this.params != null && !"".equals(this.params)) {
                p = (String[]) this.params.split("\\|\\|");
                for (int i = 0; i < p.length; i++) {
                    p[i] = strUtil.replace(p[i], "<", "&lt;");
                    p[i] = strUtil.replace(p[i], ">", "&gt;");
                    p[i] = strUtil.replace(p[i], "\"", "&quot;");
                }
            }

            try {
                //if (isWithCode() && Constants.ERROR_WITH_CODE) {
             //       msg = msgUtil.getMessage(this.msgCode, p);
             //   } else {
                    msg = msgUtil.getMessageWithoutCode(this.msgCode, p);
            //    }
            } catch (Exception e) {
                msg = this.msgCode + ": Message code not existed.";
            }
        } else {
            return SKIP_BODY;
        }

        if (msg != null && !"".equals(msg)) {
            JspWriter out = pageContext.getOut();
            try {
                StringBuffer results = new StringBuffer("<span");
                if (!strUtil.isNull(this.style)) {
                    results.append(" style=\"" + this.style + "\"");
                }
                if (!strUtil.isNull(this.styleClass)) {
                    results.append(" class=\"" + this.styleClass + "\"");
                }
                results.append(" id=\"" + this.msgCode + "\">");
                results.append(msg);
                results.append("</span>");
                out.write(results.toString());
            } catch (IOException e) {
                throw new JspException(e);
            }
        }

        return EVAL_BODY_INCLUDE;
    }
}