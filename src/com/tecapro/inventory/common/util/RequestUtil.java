/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServletWrapper;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.upload.MultipartRequestHandler;
import org.apache.struts.upload.MultipartRequestWrapper;
import org.apache.struts.util.ModuleUtils;
import org.apache.struts.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.action.TilesLayoutAction;
import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.form.BaseForm;

/**
 * Request util class
 *
 */
@Component("RequestUtil")
public class RequestUtil {
    
    /**
     * menu JSP file
     */
    private static final String ACT_LIST_FILE = "list_get_action.act";
    
    /**
     * list action
     */
    private static Map<String, Integer> actList = new HashMap<String, Integer>();
    
    /**
     * instance of ItemPropertyUtil
     */
    @Autowired
    private ItemPropertyUtil itemPropUtil;
    
    /**
     * instance of BeanUtil
     */
    @Autowired
    private BeanUtil<?> beanUtil;
    
    /**
     * instance of CommonUtil
     */
    @Autowired
    private CommonUtil commonUtil;

    /**
     * @see RequestUtils#applicationInstance
     */
    public Object applicationInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return RequestUtils.applicationInstance(className);
    }
    
    /**
     * load action list
     * 
     * @throws IOException
     */
    public Map<?, ?> loadActList(String path) throws IOException {
        
        if (actList.size() <= 0) {
            
        	String line = null;
            BufferedReader reader = null;
            
            try {
                // add list plus
                InputStream istream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ACT_LIST_FILE);
                reader = new BufferedReader(commonUtil.createInputStreamReader(istream));
                while (reader.ready()) {
                    line = reader.readLine();
                    line = (line.indexOf("/") == -1) ? ("/" + line) : line;
                    line = (line.indexOf(".do") == -1) ? (line + ".do") : line;
                    actList.put(line.trim(), 1);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return actList;
    }

    /**
     * 
     * @see RequestUtils#getMultipartHander
     * 
     */
    private MultipartRequestHandler getMultipartHandler(HttpServletRequest request) throws ServletException {
        MultipartRequestHandler multipartHandler = null;
        String multipartClass = (String) request.getAttribute(Globals.MULTIPART_KEY);

        request.removeAttribute(Globals.MULTIPART_KEY);

        // Try to initialize the mapping specific request handler
        if (multipartClass != null) {
            try {
                multipartHandler = (MultipartRequestHandler) applicationInstance(multipartClass);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (InstantiationException ie) {
                System.out.println(ie);
            } catch (IllegalAccessException iae) {
                System.out.println(iae);
            }
            if (multipartHandler != null) {
                return multipartHandler;
            }
        }

        ModuleConfig moduleConfig = ModuleUtils.getInstance().getModuleConfig(request);

        multipartClass = moduleConfig.getControllerConfig().getMultipartClass();

        // Try to initialize the global request handler
        if (multipartClass != null) {
            try {
                multipartHandler = (MultipartRequestHandler) applicationInstance(multipartClass);
            } catch (ClassNotFoundException cnfe) {
                throw new ServletException("Cannot find multipart class \"" + multipartClass + "\"" + ", exception: " + cnfe.getMessage());
            } catch (InstantiationException ie) {
                throw new ServletException("InstantiationException when instantiating " + "multipart class \"" + multipartClass + "\", exception: "
                        + ie.getMessage());
            } catch (IllegalAccessException iae) {
                throw new ServletException("IllegalAccessException when instantiating " + "multipart class \"" + multipartClass + "\", exception: "
                        + iae.getMessage());
            }

            if (multipartHandler != null) {
                return multipartHandler;
            }
        }

        return multipartHandler;
    }

    /**
     * <p>
     * Create a <code>Map</code> containing all of the parameters supplied for a
     * multipart request, keyed by parameter name. In addition to text and file
     * elements from the multipart body, query string parameters are included as
     * well.
     * </p>
     * 
     * @param request
     *            The (wrapped) HTTP request whose parameters are to be added to
     *            the map.
     * @param multipartHandler
     *            The multipart handler used to parse the request.
     * @return the map containing all parameters for this multipart request.
     */
    @SuppressWarnings("unchecked")
    private Map<String, Object> getAllParametersForMultipartRequest(HttpServletRequest request, MultipartRequestHandler multipartHandler) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Hashtable<String, Object> elements = (Hashtable<String, Object>) multipartHandler.getAllElements();
        Enumeration<String> e = elements.keys();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();

            parameters.put(key, elements.get(key));
        }

        if (request instanceof MultipartRequestWrapper) {
            request = (HttpServletRequest) ((MultipartRequestWrapper) request).getRequest();
            e = (Enumeration<String>) request.getParameterNames();

            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();

                parameters.put(key, request.getParameterValues(key));
            }
        }

        return parameters;
    }

    /**
     * <p>
     * Populate the properties of the specified JavaBean from the specified HTTP
     * request, based on matching each parameter name (plus an optional prefix
     * and/or suffix) against the corresponding JavaBeans "property setter"
     * methods in the bean's class. Suitable conversion is done for argument
     * types as described under <code>setProperties</code>.
     * </p>
     * 
     * <p>
     * If you specify a non-null <code>prefix</code> and a non-null
     * <code>suffix</code>, the parameter name must match <strong>both</strong>
     * conditions for its value(s) to be used in populating bean properties. If
     * the request's content type is "multipart/form-data" and the method is
     * "POST", the <code>HttpServletRequest</code> object will be wrapped in a
     * <code>MultipartRequestWrapper</code object.
     * </p>
     * 
     * @param bean
     *            The JavaBean whose properties are to be set
     * @param prefix
     *            The prefix (if any) to be prepend to bean property names when
     *            looking for matching parameters
     * @param suffix
     *            The suffix (if any) to be appended to bean property names when
     *            looking for matching parameters
     * @param request
     *            The HTTP request whose parameters are to be used to populate
     *            bean properties
     * @throws ServletException
     *             if an exception is thrown while setting property values
     */
    public void populate(Object bean, String prefix, String suffix, HttpServletRequest request) throws ServletException {
        // Build a list of relevant request parameters from this request
        HashMap<String, Object> properties = new HashMap<String, Object>();

        // Iterator of parameter names
        Enumeration<String> names = null;

        // Map for multipart parameters
        Map<String, Object> multipartParameters = null;

        String contentType = request.getContentType();
        String method = request.getMethod();
        boolean isMultipart = false;

        if (bean instanceof ActionForm) {
            ((ActionForm) bean).setMultipartRequestHandler(null);
        }

        MultipartRequestHandler multipartHandler = null;
        if ((contentType != null) && (contentType.startsWith("multipart/form-data")) && (method.equalsIgnoreCase("POST"))) {
            // Get the ActionServletWrapper from the form bean
            ActionServletWrapper servlet;

            if (bean instanceof ActionForm) {
                servlet = ((ActionForm) bean).getServletWrapper();
            } else {
                throw new ServletException("bean that's supposed to be " + "populated from a multipart request is not of type "
                        + "\"org.apache.struts.action.ActionForm\", but type " + "\"" + bean.getClass().getName() + "\"");
            }

            // Obtain a MultipartRequestHandler
            multipartHandler = getMultipartHandler(request);

            if (multipartHandler != null) {
                isMultipart = true;

                // Set servlet and mapping info
                servlet.setServletFor(multipartHandler);
                multipartHandler.setMapping((ActionMapping) request.getAttribute(Globals.MAPPING_KEY));

                // Initialize multipart request class handler
                multipartHandler.handleRequest(request);

                // stop here if the maximum length has been exceeded
                Boolean maxLengthExceeded = (Boolean) request.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);

                if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue())) {
                    ((ActionForm) bean).setMultipartRequestHandler(multipartHandler);
                    return;
                }

                // retrieve form values and put into properties
                multipartParameters = getAllParametersForMultipartRequest(request, multipartHandler);
                names = Collections.enumeration(multipartParameters.keySet());
            }
        }

        if (!isMultipart) {
            names = (Enumeration<String>) request.getParameterNames();
        }

        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String stripped = name;

            if (prefix != null) {
                if (!stripped.startsWith(prefix)) {
                    continue;
                }

                stripped = stripped.substring(prefix.length());
            }

            if (suffix != null) {
                if (!stripped.endsWith(suffix)) {
                    continue;
                }

                stripped = stripped.substring(0, stripped.length() - suffix.length());
            }

            Object parameterValue = null;

            if (isMultipart) {
                parameterValue = multipartParameters.get(name);
            } else {
                parameterValue = request.getParameterValues(name);
            }

            // Populate parameters, except "standard" struts attributes
            // such as 'org.apache.struts.action.CANCEL'
            if (!(stripped.startsWith("org.apache.struts."))) {

                 if (parameterValue instanceof String[] && !stripped.equals("value.passwd") && !stripped.equals("value.password")) {

                    String[] params = (String[]) parameterValue;
                    
                    for (int i = 0, n = params.length; i < n; i++) {

                        String result = params[i];

                        ItemValidationInfoValue itemInfo = itemPropUtil.getItemInfo(name);

                        if (itemInfo != null) {
  
                            if (itemInfo.getNumSeisuLength() != null) {
                                result = result.replaceAll(",", "").replaceAll("¥", "");
                            }
 
                            if (itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM_DD)
                                    || itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM)
                                    || itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_1)
                                    || itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_2)
                                    || itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_3)
                                    || itemInfo.getFormat().contains(Constants.DateFormat.YYYY_MM_DD_HH_II_SS_4)) {
                                result = result.replaceAll("/", "-");
                            }
                        }

                        params[i] = result.trim();
                    }
                }
                properties.put(stripped, parameterValue);
            }
        }

        // Set the corresponding properties of our bean
        try {
            BaseForm zform = (BaseForm) bean;
            Object obj = zform.getObjAction();
            if (obj != null && !(obj instanceof TilesLayoutAction)) {
                // clear old data if data input valid
                zform.getProperties().clear();
            }
            
            beanUtil.populate(properties, bean);
            
            if (obj != null && !(obj instanceof TilesLayoutAction)) {
                if (zform.getErrorFlag()) {
                    // hold old data if data input invalid
                    zform.setProperties(properties);
                }
            }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            if (multipartHandler != null) {
                // Set the multipart request handler for our ActionForm.
                // If the bean isn't an ActionForm, an exception would have been
                // thrown earlier, so it's safe to assume that our bean is
                // in fact an ActionForm.
                ((ActionForm) bean).setMultipartRequestHandler(multipartHandler);
            }
        }
    }

}
