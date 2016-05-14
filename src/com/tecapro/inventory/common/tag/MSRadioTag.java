/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.tag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.taglib.nested.html.NestedRadioTag;

import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * Radio custom tag
 *
 */
public class MSRadioTag extends NestedRadioTag {

    private static final long serialVersionUID = 24040529826228057L;
    
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

    private Boolean keyExistTed(String key, List<HashMap<String, Boolean>> checkList) {
        Boolean result = false;
        Iterator<HashMap<String, Boolean>> ite = checkList.iterator();
        while (ite.hasNext()) {
            HashMap<String, Boolean> item = ite.next();
            Iterator<?> iter = item.entrySet().iterator();
            if (iter.hasNext()) {
                Map.Entry<?, ?> mEntry = (Map.Entry<?, ?>) iter.next();
                if (key.equals(mEntry.getKey())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            TilesInfoValue tilesValue = (TilesInfoValue) pageContext.getAttribute(TilesInfoValue.class.getSimpleName(), PageContext.REQUEST_SCOPE);

            BaseForm form = (BaseForm) pageContext.getRequest().getAttribute(BaseForm.class.getSimpleName());

            tilesValue.setInfo(form.getValue().getInfo());

            if (getDisabled() && getValue().equals(BeanUtils.getProperty(form, getProperty()))) {
                setDisabled(false);
            }

            if (tilesValue.isReadonly()) {
                setDisabled(true);
            }

            area = (area == null || "".equals(area)) ? Constants.COMMON_AREA : area;
            if (!keyExistTed(getProperty(), form.getValue().getInfo().getItem().getAreaList(area))) {
                HashMap<String, Boolean> keyMap = new HashMap<String, Boolean>();
                keyMap.put(getProperty(), isRequire());
                form.getValue().getInfo().getItem().getAreaList(area).add(keyMap);
            }

            StringBuffer colorClass = new StringBuffer();

            if (isRequire()) {
                colorClass.append(Constants.StyleClass.REQUIRE);
                colorClass.append(Constants.SPACE);
            }

            List<String> idList = form.getError().getIdList();

            for (String id : idList) {
                if (id.equals(getProperty())) {
                    colorClass.append(Constants.StyleClass.ERROR);
                    colorClass.append(Constants.SPACE);
                    break;
                }
            }

            if (colorClass.length() > 0) {
                MSTagUtil.addStyleClass(this, colorClass.toString());
            }

            MSTagUtil.setChangeFlag(this);

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
            this.require = false;
            this.area = null;
            this.setOnchange(null);
            this.setOnclick(null);
            this.setStyleClass(null);
        }
    }

}