/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.nested.html.NestedHiddenTag;

/**
 * Hidden custom tag
 *
 */
public class MSHiddenTag extends NestedHiddenTag {
    
    private static final long serialVersionUID = 4770581662008631697L;
    
    private String area = null;
    //private Boolean addChk = true;

    public String getArea() {
        return area;
    }
    
    public MSHiddenTag() {
        super();
    }
    
    public MSHiddenTag(Boolean addChk) {
        super();
        //this.addChk = addChk;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    @Override
    public int doStartTag() throws JspException {

        /*if (addChk) {
            BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());
            
            HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
            keyMap.put(getProperty(), false);
            area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
            form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);
        }*/

        return super.doStartTag();
    }
    
    @Override
    public int doEndTag() throws JspException {
        try {
            return super.doEndTag();
        } finally {
            this.area = null;
        }
    }

}
