/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.tecapro.inventory.common.bean.ErrorInfoValue;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.ItemPropertyUtil;
import com.tecapro.inventory.common.util.LogUtil;
import com.tecapro.inventory.common.util.MessageUtil;
import com.tecapro.inventory.common.util.PropertiesUtil;

/**
 * BaseServlet action class
 * @see org.apache.struts.action.ActionServlet
 *
 */
public class BaseServlet extends ActionServlet implements Serializable {
    
    private static final long serialVersionUID = 4418322170191267945L;
    
    private static final String BEAN_NAME_LOG_UTIL = "LogUtil";
    private static final String BEAN_NAME_MESSAGE_UTIL = "MessageUtil";
    private static final String BEAN_NAME_ITEM_PROP_UTIL = "ItemPropertyUtil";
    private static final String BEAN_NAME_PROP_UTIL = "PropertiesUtil";
    private static final String BEAN_NAME_COMMON_UTIL = "CommonUtil";

    private static final Log LOG = LogFactory.getLog(BaseServlet.class);

    /*
     * (non-Javadoc)
     * @see org.apache.struts.action.ActionServlet#destroy()
     */
    @Override
    public void destroy() {
        super.destroy();
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts.action.ActionServlet#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            super.process(request, response);
        } catch (Throwable e) {
            System.out.println("RequestURL: " + request.getRequestURL());
            e.printStackTrace();
            
            LogUtil logUtil = (LogUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_LOG_UTIL);
            logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), "process", null, "RequestURL: " + request.getRequestURL());
            
            BaseForm zform = (BaseForm) request.getAttribute(BaseForm.class.getSimpleName());
            if (zform != null) {
                errorLog(zform, request, e, "process");
                
                // process error
                ErrorInfoValue errorValue = new ErrorInfoValue();
                List<String> idList = new ArrayList<String>();
                idList.add(Constants.SYSTEM_ERROR_CODE);
                errorValue.setIdList(idList);
                MessageUtil msgUtil = (MessageUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_MESSAGE_UTIL);
                errorValue.setErrorMessage(msgUtil.getMessage(Constants.SYSTEM_ERROR_CODE, new String[]{}));
                
                // check request ajax
                if (Constants.REQUEST_AJAX.equals(zform.getType())) {
                    request.setAttribute("type", Constants.REQUEST_AJAX);
                    
                    // Set header info
                    response.setContentType(Constants.CONTENT_TYPE_AJAX);
                    response.setCharacterEncoding(Constants.Text.UTF_8);
                    PrintWriter out = response.getWriter();
                    Gson gson = new Gson();
                    
                    // create data JSON to response
                    Map<String, Object> mapData = new HashMap<String, Object>();
                    
                    // check error
                    mapData.put("value", errorValue);
                    
                    out.print(gson.toJson(mapData));
                    out.flush();
                    out.close();
                } else {
                    
                    zform.setError(errorValue);
                    
                    // forward error screen
                    getServletContext().getRequestDispatcher("/WEB-INF/pages/common/system-error.jsp").forward(request, response);
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts.action.ActionServlet#init()
     */
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            CommonUtil commonUtil = (CommonUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_COMMON_UTIL);
            ItemPropertyUtil itemPropUtil = (ItemPropertyUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_ITEM_PROP_UTIL);
            PropertiesUtil propUtil = (PropertiesUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_PROP_UTIL);
            commonUtil.init();
            itemPropUtil.init();
            propUtil.init();
        } catch (Exception exception) {
            errorLog(null, null, exception, "init");
            throw new ServletException(exception);
        }

    }

    /**
     * Error log output
     * 
     * @param zform
     * @param request
     * @param e
     * @param method
     */
    protected void errorLog(BaseForm zform, HttpServletRequest request, Throwable e, String method) {

        InfoValue info = null;

        if (zform != null) {
            info = zform.getValue().getInfo();
        } else {
            info = new InfoValue();
        }

        LogUtil logUtil = (LogUtil) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(BEAN_NAME_LOG_UTIL);
        
        logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, "------ Error information ------");
        logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, e);

        if (request != null) {
            logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, "------ Input information ------");
            logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, logUtil.dump(request.getParameterMap()));
        }

        if (zform != null) {
            logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, "------ Output information ------");
            logUtil.errorLog(LOG, BaseServlet.class.getSimpleName(), method, info, logUtil.dump(zform));
        }

    }
}
