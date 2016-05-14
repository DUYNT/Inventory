/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.tiles.TilesRequestProcessor;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.ErrorInfoValue;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.BeanUtil;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.RequestUtil;

/**
 * Order of action: processActionForm(), processPopulate(),
 * processActionPerform()
 * 
 */
public class DelegatingRequestProcessor extends TilesRequestProcessor {

    private static final String TILE_PREFIX = "Tiles";
    private static final String ACTION_PREFIX = "Action";
    private static final String PATH_TILESACTION = "/" + TILE_PREFIX;
    private static final String BEAN_NAME_TILESACTION = "BaseTilesAction";
    private static final String BEAN_NAME_ACTION = "BaseAction";
    private static final String BEAN_NAME_FORM = "BaseForm";
    private static final String BEAN_NAME_BEAN_UTIL = "BeanUtil";
    private static final String BEAN_NAME_COMMON_UTIL = "CommonUtil";
    private static final String BEAN_NAME_REQUEST_UTIL = "RequestUtil";

    /**
     * get bean util
     * 
     * @return
     */
    private BeanUtil<?> getBeanUtil() {
        return (BeanUtil<?>) WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext()).getBean(BEAN_NAME_BEAN_UTIL);
    }

    /**
     * get common util
     * 
     * @return
     */
    private CommonUtil getCommonUtil() {
        return (CommonUtil) WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext()).getBean(BEAN_NAME_COMMON_UTIL);
    }

    /**
     * get request util
     * 
     * @return
     */
    private RequestUtil getRequestUtil() {
        return (RequestUtil) WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext()).getBean(BEAN_NAME_REQUEST_UTIL);
    }

    @Override
    protected Action processActionCreate(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) throws IOException {

        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext());
        Action action = (Action) appContext.getBean(getActionBeanName(mapping));

        if (action != null) {
            action.setServlet(this.servlet);
            return action;
        } else {
            // If cannot create Action then create default action by super class
            return super.processActionCreate(request, response, mapping);
        }
    }

    /**
     * get action bean name
     * 
     * @param mapping
     *            ActionMapping
     * @return String ActionMapping
     */
    protected String getActionBeanName(ActionMapping mapping) {
        if (mapping.getPath().startsWith(PATH_TILESACTION)) {
            return BEAN_NAME_TILESACTION;
        }
        return BEAN_NAME_ACTION;
    }

    /**
     * Populate request form
     * 
     * @see org.apache.struts.action.RequestProcessor
     *      .processPopulate(HttpServletRequest request, HttpServletResponse
     *      response, ActionForm form, ActionMapping mapping) throws
     *      ServletException
     */
    @Override
    protected void processPopulate(HttpServletRequest request, HttpServletResponse response, ActionForm form, ActionMapping mapping) throws ServletException {

        /**
         * Base64 is encoded value for form.value, it is null as the first time
         * access to the application
         */
        String valueStr = (String) request.getParameter("valueBase64");
        BaseForm zform = (BaseForm) form;
        String contentType = request.getContentType();
        boolean multipart = contentType != null && contentType.startsWith("multipart/form-data");

        if (multipart) {
            
            populate(request, response, zform, mapping);
            getBeanUtil().describe("value", zform.getValue(), false);
            valueStr = zform.getValueBase64();
        }

        // Encode data by base64 method
        if (valueStr != null) {

            try {
                InfoValueIF decodeValue = (InfoValueIF) decodeBase64("valueBase64", request, zform);

                if (decodeValue != null) {
                    /** Check if user navigate to other form than current form */
                    if (zform.getValue().getClass().getSimpleName().equals(decodeValue.getClass().getSimpleName())) {
                        zform.setValue(decodeValue);
                    } else {
                        zform.getValue().setInfo(decodeValue.getInfo());
                    }
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        if (multipart) {
            getBeanUtil().populate(request.getParameterMap(), form);
        } else {
            populate(request, response, zform, mapping);
        }
        zform.setInputData(request.getParameterMap());
    }

    /**
     * get data from request and put data to BaseForm
     * 
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param form
     *            BaseForm
     * @param mapping
     *            ActionMapping
     * @throws ServletException
     */
    protected void populate(HttpServletRequest request, HttpServletResponse response, BaseForm form, ActionMapping mapping) throws ServletException {

        form.setServlet(this.servlet);
        form.reset(mapping, request);

        if (mapping.getMultipartClass() != null) {
            request.setAttribute(Globals.MULTIPART_KEY, mapping.getMultipartClass());
        }

        getRequestUtil().populate(form, mapping.getPrefix(), mapping.getSuffix(), request);

        // Set the cancellation request attribute if appropriate
        if (request.getParameter(Globals.CANCEL_KEY) != null) {
            request.setAttribute(Globals.CANCEL_KEY, Boolean.TRUE);
        }
    }

    /**
     * @see org.apache.struts.tiles.TilesRequestProcessor .init(ActionServlet
     *      servlet, ModuleConfig moduleConfig) throws ServletException
     */
    @Override
    public void init(ActionServlet actionServlet, ModuleConfig moduleConfig) throws ServletException {
        super.init(actionServlet, moduleConfig);
    }

    /**
     * @see com.viettel.common.action.DelegatingRequestProcessor.
     *      processActionForm(HttpServletRequest request, HttpServletResponse
     *      response, ActionMapping mapping)
     */
    @Override
    protected ActionForm processActionForm(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) {

        /**
         * Set logic and value object for form before calling super method
         */
        BaseForm form = (BaseForm) WebApplicationContextUtils.getWebApplicationContext(this.servlet.getServletContext()).getBean(BEAN_NAME_FORM);

        String prefix = "";
        // clear error
        if (!getBaseName(mapping).contains(TILE_PREFIX)) {
            form.setError(new ErrorInfoValue());
        } else {
            prefix = "Layout";
        }

        if (form != null) {

            DelegateAction objAction = null;
            try {
                // load action object
                objAction = (DelegateAction) WebApplicationContextUtils.getWebApplicationContext(
                                this.servlet.getServletContext()).getBean(getBaseName(mapping) + prefix + ACTION_PREFIX);
            } catch (Exception e) {
                e.printStackTrace();
                objAction = null;
            }

            // cache action object
            String actMethod = getMethodName(mapping);
            form.setObjAction(objAction);
            if (objAction != null) {

                objAction.setActMethod(actMethod);

                // load validator object
                try {
                    Object objValidator = (Object) WebApplicationContextUtils.getWebApplicationContext(
                                    this.servlet.getServletContext()).getBean(getBaseName(mapping) + "Validate");
                    objAction.setLogicValidate(objValidator);
                    objAction.setValMethod(actMethod + "Validate");
                } catch (Exception e) {
                    objAction.setLogicValidate(null);
                    objAction.setValMethod("");
                }
            }

            // load value object
            InfoValueIF value = (InfoValueIF) WebApplicationContextUtils.getWebApplicationContext(
                            this.servlet.getServletContext()).getBean(getBaseName(mapping) + "Value");

            boolean isShouldSaveForm = (form.getValue() != null && !form.getValue().getClass().getSimpleName().contains(TILE_PREFIX));
            if (getBaseName(mapping).contains(TILE_PREFIX) && isShouldSaveForm) {
                request.setAttribute(form.getClass().getSimpleName() + "_Value", form.getValue());
            }

            form.setValue(value);
            value.setInfo(new InfoValue());

            return form;
        }

        return super.processActionForm(request, response, mapping);
    }

    /**
     * Set value object for <code>form.delegateFacade.action.value</code>
     * 
     * @see org.apache.struts.action.RequestProcessor
     *      .processActionPerform(HttpServletRequest request,
     *      HttpServletResponse response, Action action, ActionForm form,
     *      ActionMapping mapping) throws IOException, ServletException
     */
    @Override
    protected ActionForward processActionPerform(HttpServletRequest request, HttpServletResponse response, 
                    Action action, ActionForm form, ActionMapping mapping) throws IOException, ServletException {

        if (form instanceof BaseForm) {

            DelegateAction objAction = ((DelegateAction) ((BaseForm) form).getObjAction());
            Object objValidator = objAction.getLogicValidate();

            try {
                getBeanUtil().setBean(objAction, "value", ((BaseForm) form).getValue());
                if (objValidator != null) {
                    getBeanUtil().setBean(objValidator, "value", ((BaseForm) form).getValue());
                }
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            } catch (Throwable ex) {
                throw new ServletException(ex);
            }
        }

        return super.processActionPerform(request, response, action, form, mapping);
    }

    /**
     * get Action name
     * 
     * @param mapping
     * @return action name
     */
    protected String getBaseName(ActionMapping mapping) {
        return mapping.getPath().substring(1, mapping.getPath().lastIndexOf("_"));
    }

    /**
     * get method name
     * 
     * @param mapping
     * @return method name
     */
    protected String getMethodName(ActionMapping mapping) {
        String name = mapping.getPath();
        return name.substring(name.lastIndexOf("_") + 1);
    }

    /**
     * get string key (encode base64)(9)0
     * 
     * @param name
     * @param request
     * @param form
     * @return string base64
     * @throws Exception
     */
    protected Object decodeBase64(String name, HttpServletRequest request, BaseForm form) throws Exception {

        String bytes = (String) request.getParameter(name);
        if (bytes != null) {
            return getCommonUtil().deserialize(bytes.getBytes());
        }
        return null;
    }
}
