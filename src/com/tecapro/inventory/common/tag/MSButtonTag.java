/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.taglib.html.ButtonTag;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.bean.ButtonInfoValue;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.MessageUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * ButtonTag class
 *
 */
public class MSButtonTag extends ButtonTag {
    
    private static final long serialVersionUID = 8637631821373611018L;
    
    private static final String BEAN_NAME_MSG_UTIL = "MessageUtil";
    private static final String BEAN_NAME_STR_UTIL = "StringUtil";
    
    private String nameSpace = null;
    
    private int index = 0;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            String nameSpace = "";
            if (this.nameSpace != null) {
                nameSpace = this.nameSpace;
            }

            MessageUtil msgUtil = (MessageUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_MSG_UTIL);
            StringUtil strUtil = (StringUtil) WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext()).getBean(BEAN_NAME_STR_UTIL);
                        
            TilesInfoValue value = (TilesInfoValue) pageContext.getAttribute(nameSpace + TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);
            BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());
            InfoValue info = form.getValue().getInfo();
            value.setInfo(info);
            List<ButtonInfoValue> list = value.getButtonList();
            ButtonInfoValue buttonInfo = list.get(index);
            

            if (buttonInfo == null || buttonInfo.getButtonName() == null) {
                this.setStyleClass("display_none");
                MSTagUtil.addStyleClass(this, "disabled");
                return super.doStartTag();
            }

            if (buttonInfo.getInvisible() != null) {
                String flag = BeanUtils.getProperty(form, buttonInfo.getInvisible());

                if (Constants.ONE.equals(flag)) {
                    this.setStyleClass("display_hidden");
                    return super.doStartTag();
                }
            }

            if (buttonInfo.getDisable() != null) {
                String flag = BeanUtils.getProperty(form, buttonInfo.getDisable());

                if (Constants.ONE.equals(flag)) {
                    this.setDisabled(true);
                    MSTagUtil.addStyleClass(this, "disabled");
                }
            }
            if (this.getDisabled()) {
                MSTagUtil.addStyleClass(this, "disabled");
            }

            StringBuffer onclick = new StringBuffer();
            
            if (getOnclick() != null && !"".equals(getOnclick())) {
                onclick.append(getOnclick() + ";");
            }

            if (buttonInfo.getMessageId() != null) {
                String[] params = null;
                if (buttonInfo.getMessageParam() != null) {
                    StringTokenizer token = new StringTokenizer(buttonInfo.getMessageParam(), ",");
                    List<String> tokenList = new ArrayList<String>();
                    while (token.hasMoreTokens()) {
                        tokenList.add(token.nextToken());
                    }
                    params = tokenList.toArray(new String[tokenList.size()]);
                }

                onclick.append("if (!windowConfirm('").append(msgUtil.getMessage(buttonInfo.getMessageId(), params)).append("')){return;};");
            }
            
            // dirty check msg default
            String msgId = "MSG078C";

            if (buttonInfo.isDirtyCheck() || Constants.BACK.equals(buttonInfo.getButtonName()) 
                    || Constants.MENU_MODORU.equals(buttonInfo.getButtonName())) {
                if (!strUtil.isNull(buttonInfo.getDirtyMsgId()) && !"".equals(buttonInfo.getDirtyMsgId())) {
                    msgId = buttonInfo.getDirtyMsgId();
                }
                onclick.append("if (!lossMessage('").append(msgUtil.getMessage(msgId, null)).append("')){return;};");
            }
            
            if (buttonInfo.getOnClick() != null && !"".equals(buttonInfo.getOnClick())) {
                onclick.append(buttonInfo.getOnClick() + ";");
            }

            if (buttonInfo.getAction() != null && !"".equals(buttonInfo.getAction())) {
                onclick.append("send('").append(buttonInfo.getAction()).append("');");
            }

            if (!"".equals(onclick.toString())) {
                this.setOnclick(onclick.toString());
            }
            this.setValue(buttonInfo.getButtonName());

            return super.doStartTag();
        } catch (Exception e) {
            throw new JspException(e);
        } catch (Throwable e) {
            throw new JspException(e);
        }
    }

    @Override
    public int doEndTag() throws JspException {

        try {
            return super.doEndTag();
        } finally {

            index = 0;

            this.setDisabled(false);
            this.setNameSpace(null);
            this.setOnclick(null);
            this.setValue(null);
            this.setStyleClass(null);
            this.setStyle(null);
        }
    }
    

}
