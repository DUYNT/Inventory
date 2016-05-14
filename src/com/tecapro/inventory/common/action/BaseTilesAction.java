/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.actions.TilesAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.bean.TilesInfoValue;
import com.tecapro.inventory.common.bean.UserInfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.Constants;

/**
 * Base tiles action
 *
 */
public class BaseTilesAction extends TilesAction implements Serializable {

    private static final long serialVersionUID = 344844207871762636L;
    
    private static final String ATTRIBUTE_ID = "id";
    private static final String ATTRIBUTE_ORGID = "orgid";
    private static final String ATTRIBUTE_FUNCID = "funcid";
    private static final String NAME_SPACE = "nameSpace";
    private static final String UPDATE_GAMEN = "update_gamen";

    /** instance of UserInfoValue */
    @Autowired
    private UserInfoValue userInfo;

    /*
     * (non-Javadoc)
     * @see org.apache.struts.tiles.actions.TilesAction#execute(org.apache.struts.tiles.ComponentContext, org.apache.struts.action.ActionMapping, 
     * org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("unchecked")
    @Override
    public ActionForward execute(ComponentContext context, ActionMapping mapping, 
            ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String id = (String) context.getAttribute(ATTRIBUTE_ID);
    
        context.putAttribute(ATTRIBUTE_ID, id);
        context.putAttribute(ATTRIBUTE_ORGID, id);
        context.putAttribute(ATTRIBUTE_FUNCID, id);
    
        Iterator<String> iterator = (Iterator<String>) context.getAttributeNames();
        Map<String, Object> map = new HashMap<String, Object>();
    
        for (String name = null; iterator.hasNext();) {
            name = (String) iterator.next();
    
            if (name.endsWith("dirtyCheck") 
                    || (name.endsWith("buttonName") 
                            && (Constants.BACK.equals(context.getAttribute(name)) 
                                    || Constants.MENU_MODORU.equals(context.getAttribute(name))))) {
                context.putAttribute(UPDATE_GAMEN, "1");
            }
            map.put("value." + name, context.getAttribute(name));
        }
        BeanUtils.populate(form, map);
    
        String nameSpace = "";
        if (context.getAttribute(NAME_SPACE) != null) {
            nameSpace = (String) context.getAttribute(NAME_SPACE);
        }
        request.setAttribute(nameSpace + TilesInfoValue.class.getSimpleName(), ((BaseForm) form).getValue());

        // set userInfo to object info
        InfoValue info = ((BaseForm) form).getValue().getInfo();
        info.setUserInfo(userInfo);
        
        return null;
    }

}
