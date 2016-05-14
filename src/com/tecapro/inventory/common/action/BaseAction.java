/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.apache.struts.action.ActionServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.ErrorInfoValue;
import com.tecapro.inventory.common.bean.FileInfoValue;
import com.tecapro.inventory.common.bean.FormFileValue;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.bean.ItemValidationInfoValue;
import com.tecapro.inventory.common.bean.PageInfoValue;
import com.tecapro.inventory.common.bean.UserInfoValue;
import com.tecapro.inventory.common.exception.DBException;
import com.tecapro.inventory.common.exception.FileException;
import com.tecapro.inventory.common.exception.MSException;
import com.tecapro.inventory.common.exception.RequiredCheckException;
import com.tecapro.inventory.common.form.BaseForm;
import com.tecapro.inventory.common.util.BeanUtil;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.Constants;
import com.tecapro.inventory.common.util.ItemCheckUtil;
import com.tecapro.inventory.common.util.ItemPropertyUtil;
import com.tecapro.inventory.common.util.LogUtil;
import com.tecapro.inventory.common.util.MessageUtil;
import com.tecapro.inventory.common.util.RemoteAddressUtil;
import com.tecapro.inventory.common.util.RequestUtil;
import com.tecapro.inventory.common.util.StreamUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * BaseAction class
 *
 */
public class BaseAction extends Action implements Serializable {

    private static final long serialVersionUID = 1152087132313370763L;

    private static final Log LOG = LogFactory.getLog(BaseAction.class);

    /**
     * Error forward name
     */
    private static final String ERROR_FORWARD = "failure";
    
    /**
     * define action forward of login screen
     */
    private static final String LOGIN = "login";
    /**
     * success forward
     */
    private static final String SUCCESS_FORWARD = "success";

    /**
     * struts action when no session
     */
    private static final String PARAM_NO_SESSION = "no_session";

    /**
     * struts action when create session
     */
    private static final String PARAM_CREATE_SESSION = "create_session";

    /**
     * struts action when session invalidate
     */
    private static final String PARAM_INVALIDATE_SESSION = "invalidate_session";
    
    /**
     * Post http method
     */
    private static final String GET_METHOD = "GET";
    private static final String INDEX_PAGE = "";
    
    /**
     * defined for list paging
     */
    private static final String LIST_PAGE_ONE = "1";
    private static final String LIST_PAGE_TWO = "2";
    private static final String LIST_PAGE_THREE = "3";
    
    /**
     * Parameter window name
     */
    private static final String PARAM_WINDOW_NAME = "wn";

    /**
     * define action forward of error screen
     */
    private static final String SYSTEM_ERROR = "systemError";

    /**
     * key divider filename
     */
    private static final String DIVIDER_KEY = "||";

    /**
     * contain error code to check duplicate
     */
    private Map<String, Integer> errorCheck = new HashMap<String, Integer>();

    /**
     * flag to check reset form data
     */
    private Boolean isResetData = false;

    /**
     * defined list name for field upload
     */
    private static final String FIELD_FILE = ".file";

    /** instance of StringUtil */
    @Autowired
    private StringUtil strUtil;

    /** instance of StreamUtil */
    @Autowired
    private StreamUtil streamUtil;


    /** instance of BeanUtil */
    @Autowired
    private BeanUtil<?> beanUtil;

    /** instance of LogUtil */
    @Autowired
    private LogUtil logUtil;

    /** instance of MessageUtil */
    @Autowired
    private MessageUtil msgUtil;

    /** instance of CommonUtil */
    @Autowired
    private CommonUtil commonUtil;

    /** instance of RequestUtil */
    @Autowired
    private RequestUtil requestUtil;

    /** instance of ItemCheckUtil */
    @Autowired
    private ItemCheckUtil itemCheckUtil;

    /**
     * instance of ItemPropertyUtil
     */
    @Autowired
    private ItemPropertyUtil itemPropUtil;

    /** instance of UserInfoValue */
    @Autowired
    private UserInfoValue userInfo;

    /** instance of RemoreAddressUtil */
    @Autowired
    private RemoteAddressUtil remoteAddressUtil;

    /**
     * Action start log output
     */
    private long startLog(ActionMapping mapping, BaseForm form) {
        return logUtil.startLog(LOG, mapping.getPath(), "execute", form.getValue().getInfo());
    }

    /**
     * Action end log output
     */
    private void endLog(ActionMapping mapping, BaseForm form, long startTime) {
        logUtil.endLog(LOG, mapping.getPath(), "execute", form.getValue().getInfo(), startTime);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, 
     * javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
     */
    @SuppressWarnings("unchecked")
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
                    throws Exception {
        BaseForm zform = (BaseForm) form;

        long startTime = startLog(mapping, zform);

        Object objAction = zform.getObjAction();
        InfoValue info = zform.getValue().getInfo();

        byte[] serializeData = null;
        String result = null;
        boolean hasError = false;
        String errorCode = "";
        HashMap<String, List<HashMap<String, Boolean>>> checkListBak = null;

        try {
            
            /*Detect device*/
            request.setAttribute(Constants.Device.IS_TABLET, detectDevice(request).isTablet());
            
            String systemError = request.getParameter("system_error");
            if (!strUtil.isNull(systemError) 
                            && (Constants.SYSTEM_ERROR_CODE.equals(systemError) || Constants.SESSION_TIMEOUT_CODE.equals(systemError))) {
                
                setError(zform, systemError, null, new ArrayList<String>(), request);
                request.setAttribute(mapping.getName(), zform);
                
                return mapping.findForward(SYSTEM_ERROR);
            }

            serializeData = (zform.getValueBase64() != null && !"".equals(zform.getValueBase64())) ? zform.getValueBase64().getBytes() : commonUtil
                    .serialize(zform.getValue());

            // Initialization for uploading and downloading
            initFile(zform);

            // If the session is invalid, I will transition to login screen
            if (!validSession(zform, request, mapping)) {

                setError(zform, Constants.SESSION_TIMEOUT_CODE, null, new ArrayList<String>(), request);
                request.setAttribute(mapping.getName(), zform);

                // check request ajax
                if (Constants.REQUEST_AJAX.equals(zform.getType())) {
                    request.setAttribute("type", Constants.REQUEST_AJAX);
                    throw new MSException(Constants.SESSION_TIMEOUT_CODE, new String[]{});
                }

                return mapping.findForward(SYSTEM_ERROR);
            } else {

                // check request invalid
                if (isNotAcceptAction(request)) {
                    response.sendRedirect(request.getContextPath() + INDEX_PAGE);
                    return null;
                }

                copyDataToInfoValue(zform, request);
            }
         // check login
            if (!(mapping.getPath().equalsIgnoreCase("/Login_init") || mapping.getPath().equalsIgnoreCase("/Login_login"))) {
                ActionForward actionForward = null;
                result = LOGIN;
                if (info.getUserInfo().getUsername() == null || info.getUserInfo().getUsername().equals("")) {
                    // Create action forward
                    actionForward = createActionForward(result, request, mapping, zform);
                    zform.setPath(actionForward.getPath());

                    endLog(mapping, zform, startTime);
                    ActionRedirect redirect = new ActionRedirect(actionForward);
                    if (!strUtil.isNull(info.getWinName())) {
                        redirect.addParameter(PARAM_WINDOW_NAME, info.getWinName());
                    }
                    return redirect;
                }
            }
            // check download request
            if (checkDownloadRequest(zform, request, response)) {
                endLog(mapping, zform, startTime);
                return null;
            } else {

                // copy file to work folder
                copyTempFile(form, zform);
                
                // get remote ip address
               // userInfo.setIpAddress(remoteAddressUtil.getIpddress(request));

                // Form validation
                if (mapping.getValidate()) {

                    result = checkValidate(mapping, form, zform, request, objAction, serializeData);
                }

                if (!ERROR_FORWARD.equals(result)) {

                    // set error flag is true
                    zform.setErrorFlag(false);
                    // clear info message
                    info.getInfoMsg().clear();
                    
                    // process for paging
                    processPagingBeforeAction(info, request);
                    
                    String[] inputs = (String[]) request.getParameterMap().get(PARAM_WINDOW_NAME);
                    if (inputs != null && !strUtil.isNull((String) inputs[0])) {
                        info.setWinName((String) inputs[0]);
                    }
                    
                    // execute method logic
                    result = ((DelegateAction) objAction).execute(info);

                    // process for paging
                    processPagingAfterAction(info, request);

                    // copy info message to BaseForm
                    zform.setInfoMsg(info.getInfoMsg());

                    // build error message set from logic
                    String ret = createErrorFromLogic(zform, serializeData, request);
                    if (ret != null && !"".equals(ret) && !SUCCESS_FORWARD.equals(ret)) {
                        result = ret;
                    }
                } else {
                    // set error flag is true
                    zform.setErrorFlag(true);
                }

                if (!ERROR_FORWARD.equals(result)) {
                    changeSession(zform, request, mapping);
                }
                
                // If the file name when download is set from business, the download process
                FileInfoValue fileDown = info.getFile().get(0);
                
                if (!ERROR_FORWARD.equals(result) && fileDown != null 
                                && fileDown.getDownloadFileName() != null 
                                && !"".equals(fileDown.getDownloadFileName())) {
                    if (!fileDown.getDownloadAfter()) {
                        downloadFile(zform, response);
                        endLog(mapping, zform, startTime);
                        return null;
                    } else {
                        fileDown.setDownloadAfter(false);
                        HttpSession session = request.getSession(false);

                        // set fileName of user into http request
                        String dataFile = fileDown.getDownloadFileName();
                        dataFile = session.getId() + DIVIDER_KEY + dataFile;
                        request.setAttribute(Constants.DOWNLOAD_KEY, new String(commonUtil.serialize(dataFile)));
                    }
                }
            }
        } catch (Exception ex) {
            
            result = ERROR_FORWARD;
            
            // set error flag is true
            zform.setErrorFlag(true);
            
            if (ex instanceof MSException || ex.getCause() instanceof MSException) {
                String message = "";
                if (ex instanceof DBException) {
                    errorLog(zform, request, ex, "execute");
                    message = msgUtil.getMessage(((MSException) ex).getCode(), ((MSException) ex).getParam());
                } else if (ex instanceof MSException) {
                    message = msgUtil.getMessage(((MSException) ex).getCode(), ((MSException) ex).getParam());
                } else {
                    message = msgUtil.getMessage(((MSException) ex.getCause()).getCode(), ((MSException) ex.getCause()).getParam());
                }
                logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "execute", info, message);

                try {
                    result = createErrorMessage(zform, ex, serializeData, request);
                } catch (Exception ex2) {
                    hasError = true;
                }
            } else {
                hasError = true;
            }

            if (hasError) {
                errorLog(zform, request, ex, "execute");
                if (ex.getCause() instanceof MSException) {
                    errorCode = ((MSException)ex.getCause()).getCode();
                } else if (ex instanceof MSException) {
                    errorCode = ((MSException)ex).getCode();
                }
                if ("".equals(errorCode)) {
                    errorCode = Constants.SYSTEM_ERROR_CODE;
                }
            }
        } finally {
            try {

                if (Constants.REQUEST_AJAX.equals(zform.getType())) {
                    // backup checklist
                    checkListBak = (HashMap<String, List<HashMap<String, Boolean>>>) info.getItem().getCheckList().clone();
                }
                
                info.getItem().getCheckList().clear();

                // If the file upload is done, I want to delete the temporary files when uploading
                if (form.getMultipartRequestHandler() != null) {
                    deleteUploadFile(zform);
                }

                // reset data to after submit
                if (isResetData && info.getResetFlag()) {
                    resetData(zform, serializeData, request);
                }
            } catch (Exception ex) {
                logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "execute", info, ex);
            }
            info.setResetFlag(true);
            //if (ex instanceof Exception) {
            if (hasError) {
                msgUtil.resetErrorList();

                // add message error code
                if (!strUtil.isNull(errorCode)) {
                    setError(zform, errorCode, null, null, request);
                }
                
                result = SYSTEM_ERROR;
            }
        }
        
        ActionForward forward = null;
        
        // print data JSON for request AJAX
        if (Constants.REQUEST_AJAX.equals(zform.getType())) {
        
            // Set header info
            response.setContentType(Constants.CONTENT_TYPE_AJAX);
            response.setCharacterEncoding(Constants.Text.UTF_8);
            PrintWriter out = response.getWriter();
            
            // get JSON data
            Object objValue = zform.getValue();
            
            // set checlist
            if (checkListBak != null) {
                ((InfoValueIF) objValue).getInfo().getItem().setCheckList(checkListBak);
            }
            Method method = objValue.getClass().getSuperclass().getDeclaredMethod("getJsonData");
            Object jsonData = method.invoke(objValue);
            
            String jsonString = "";
            Gson gson = new Gson();
            
            // create data JSON to response
            Map<String, Object> mapData = new HashMap<String, Object>();
            mapData.put("paging", getPaging(zform, request));
            mapData.put("valueBase64", new String(commonUtil.serialize((InfoValueIF) objValue)));
            
            // check error
            if (!strUtil.isNull(zform.getError().getErrorId())) {
                mapData.put("value", zform.getError());
            } else if (!strUtil.isNull(jsonData)) {
                mapData.put("value", jsonData);
            }
            
            jsonString = gson.toJson(mapData);
            out.print(strUtil.isNull(jsonString) ? "" : jsonString);
            out.flush();
            out.close();
            
            endLog(mapping, zform, startTime);
            return forward;
        } else {

            // Create action forward
            forward = createActionForward(result, request, mapping, zform);
            zform.setPath(forward.getPath());
            
            endLog(mapping, zform, startTime);
            if (!forward.getRedirect()) {
                return forward;
            }
            
            ActionRedirect redirect = new ActionRedirect(forward);
            if (!strUtil.isNull(info.getWinName())) {
                redirect.addParameter(PARAM_WINDOW_NAME, info.getWinName());
            }
            
            return redirect;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.apache.struts.action.Action#setServlet(org.apache.struts.action.ActionServlet)
     */
    @Override
    public void setServlet(ActionServlet servlet) {
        super.setServlet(servlet);
    }
    
    /**
     * Detect device
     * 
     * @param request
     */
    private Device detectDevice(HttpServletRequest request) {
        Device device = DeviceUtils.getCurrentDevice(request);
        if (device == null) {
            device = new Device() {
                @Override
                public boolean isTablet() {
                    return false;
                }
                
                @Override
                public boolean isNormal() {
                    return true;
                }
                
                @Override
                public boolean isMobile() {
                    return false;
                }
            };
        }
        return device;
    }

    /**
     * check request
     *
     * @param request
     * @return
     * @throws IOException
     */
    private Boolean isNotAcceptAction(HttpServletRequest request) throws IOException {
        Map<?, ?> actList = requestUtil.loadActList(getServlet().getServletContext().getRealPath(""));
        return (!actList.containsKey(request.getServletPath()) && GET_METHOD.equals(request.getMethod()));
    }

    /**
     * get download value
     * @param request
     * @return
     * @throws Exception
     */
    private Boolean checkDownloadRequest(BaseForm zform, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Boolean result = false;
        String downloadValue = "";
        HttpSession session = request.getSession(false);
        InfoValue info = zform.getValue().getInfo();

        // get download key from request
        String downloadKey = (String) request.getParameter(Constants.DOWNLOAD_KEY);
        if (downloadKey != null && !"".equals(downloadKey)) {

            // decode download key
            downloadValue = (String) commonUtil.deserialize(downloadKey.getBytes());
        }

        // check download value
        if (downloadValue != null && !"".equals(downloadValue) && downloadValue.contains(session.getId())) {
            String fileName = downloadValue.substring(downloadValue.lastIndexOf(DIVIDER_KEY) + DIVIDER_KEY.length());

            // init download file
            info.getFile().get(0).setTempFileName(fileName, fileName);
            info.getFile().get(0).setDownloadFileName(fileName);

            // start download file
            downloadFile(zform, response);
            result = true;
        }

        request.removeAttribute(Constants.DOWNLOAD_KEY);
        info.getFile().set(0, new FileInfoValue());
        
        return result;
    }

    /**
     * Create action forward
     *
     * @param forwardName
     * @param request
     * @param mapping
     * @param zform
     * @return
     */
    private ActionForward createActionForward(String forwardName, HttpServletRequest request, ActionMapping mapping, BaseForm zform) {

        beanUtil.populate(beanUtil.describe("value", zform.getValue()), zform);
        request.setAttribute(mapping.getName(), zform);

        ActionForward forward = mapping.findForward(forwardName);

        return forward;
    }

    /**
     * Check single item
     *
     * @param mapping
     * @param form
     * @param zform
     * @param request
     * @param delegateFacade
     * @param serializeData
     * @return
     * @throws Exception
     */
    private String checkValidate(ActionMapping mapping, ActionForm form, 
                    BaseForm zform, HttpServletRequest request, Object objAction, byte[] serializeData) throws Exception {

        String result = SUCCESS_FORWARD;
        HashMap<String, Boolean> item = null;
        HashMap<String, Boolean> row = null;
        Iterator<?> iter = null;
        Iterator<?> it = null;
        Boolean require = false;
        Boolean checkFile = false;
        String[] inputValues = null;
        String inputValue = null;
        String property = null;

        Map<String, Object> paramMap = (Map<String, Object>) zform.getProperties();
        InfoValue info = zform.getValue().getInfo();
        Map<String, Integer> keyMap = new HashMap<String, Integer>();

        String areaForm = (mapping.getInput() == null || "".equals(mapping.getInput())) ? Constants.COMMON_AREA : mapping.getInput();
        List<HashMap<String, Boolean>> areaList = info.getItem().getAreaList(areaForm);

        // Validate plus
        String[] vPluss = (String[]) paramMap.get("validatePlus[" + areaForm + "]");
        if (!(vPluss == null || vPluss.length == 0)) {
            String vPlus = vPluss[0];
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<HashMap<String, Boolean>>>() { } .getType();

            // json to objectb List
            List<HashMap<String, Boolean>> oList = gson.fromJson(vPlus, collectionType);
            if (oList != null) {
                Iterator<HashMap<String, Boolean>> iRow = oList.iterator();
                while (iRow.hasNext()) {
                    // get row
                    row = iRow.next();
                    it = row.entrySet().iterator();
                    while (it.hasNext()) {
                        // get item and put to Area list
                        Map.Entry<?, ?> mEntry = (Map.Entry<?, ?>) it.next();
                        HashMap<String, Boolean> mItem = new HashMap<String, Boolean>();
                        mItem.put((String) mEntry.getKey(), (Boolean) mEntry.getValue());
                        areaList.add(mItem);
                    }
                }
            }
        }

        Iterator<HashMap<String, Boolean>> ite = areaList.iterator();

        // When sent in multipart, determines that the file upload
        if (form.getMultipartRequestHandler() != null) {
            checkFile = true;
        }

        int idxFile = 0;
        int idx = 0;
        FormFileValue formFile = null;
        while (ite.hasNext()) {

            inputValues = null;
            formFile = null;
            item = ite.next();
            iter = item.entrySet().iterator();
            property = null;
            require = false;

            if (iter.hasNext()) {
                Map.Entry<?, ?> mEntry = (Map.Entry<?, ?>) iter.next();
                property = (String) mEntry.getKey();
                require = (Boolean) mEntry.getValue();
            } else {
                continue;
            }

            if (keyMap.containsKey(property)) {
                keyMap.put(property, keyMap.get(property) + 1);
            } else {
                keyMap.put(property, 0);
            }

            if (!property.endsWith(FIELD_FILE)) {
                inputValues = (String[]) paramMap.get(property);
                
                // check item not existed to continue
                if (inputValues == null) {
                    continue;
                }
            } else if (property.lastIndexOf("[") != -1 && property.lastIndexOf("]") != -1) {
                idxFile = Integer.parseInt(property.substring(property.lastIndexOf("[") + 1, property.lastIndexOf("]")));
                formFile = zform.getFiles().get(idxFile);
            }

            // Input value
            inputValue = null;
            if (!(inputValues == null || inputValues.length == 0)) {
                inputValue = inputValues[keyMap.get(property)];
            }

            try {
                // Check require
                if (require) {
                    if (!property.endsWith(FIELD_FILE)) {
                        itemCheckUtil.checkRequired(inputValue, property);
                    } else if (checkFile && formFile != null && Constants.BLANK.equals(formFile.getFormFileName())) {
                        RequiredCheckException ex = new RequiredCheckException(Constants.FILE_BLANK_CODE, new String[] { property });
                        ex.setErrorId(property);
                        throw ex;
                    }
                }

                if (checkFile && property.endsWith(FIELD_FILE) && formFile != null && !strUtil.isNull(formFile.getFormFileName())) {
                    if (formFile.getFile() == null || formFile.getFile().getFileSize() == 0) {
                        FileException ex = new FileException(Constants.FILE_SIZE_ZERO_CODE, new String[] { property });
                        ex.setErrorId(property);
                        throw ex;
                    }
                }

                if (!(inputValues == null || inputValues.length == 0)) {

                    // Check not permit character
                    /*itemCheckUtil.checkPermitCharacter(inputValue, property);*/

                    String key = null;
                    int index = property.lastIndexOf(".");
                    if (index < 0) {
                        key = property;
                    } else {
                        key = property.substring(property.lastIndexOf(".") + 1);
                    }

                    // get item info 
                    ItemValidationInfoValue itemInfo = itemPropUtil.getItemInfo(key);

                    if (itemInfo == null) {
                        LOG.warn("Item ID is not registered. id=" + key);
                    } else {
                        // Single item check processing
                        if (inputValue != null && !Constants.BLANK.equals(inputValue)) {
                            itemCheckUtil.checkItem(itemInfo, inputValue, property);
                        }
                    }
                }

                inputValue = (inputValue == null) ? "" : inputValue;

                // Check custom validate
                if (property.lastIndexOf("[") != -1 && property.lastIndexOf("]") != -1) {
                    idx = Integer.parseInt(property.substring(property.lastIndexOf("[") + 1, property.lastIndexOf("]")));
                }

                ((DelegateAction) objAction).validate(inputValue, property, idx);

            } catch (Throwable e) {

                if (e instanceof MSException || e.getCause() instanceof MSException) {
                    String message = "";
                    if (e instanceof MSException) {
                        message = msgUtil.getMessage(((MSException) e).getCode(), ((MSException) e).getParam());
                    } else {
                        message = msgUtil.getMessage(((MSException) e.getCause()).getCode(), ((MSException) e.getCause()).getParam());
                    }
                    logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "checkValidate", info, message);
                } else {
                    errorLog(zform, request, e, "checkValidate");
                }

                try {
                    String ret = createErrorMessage(zform, e, serializeData, request);
                    if (ret != null && !"".equals(ret) && !SUCCESS_FORWARD.equals(ret)) {
                        result = ret;
                    }
                } catch (Exception ex) {
                    errorLog(zform, request, ex, "checkValidate");
                    throw ex;
                }
                
                // validate item one by one 
                return result;
            }
        }

        return result;
    }

    /**
     * Error when log output
     *
     * @param zform
     * @param request
     * @param e
     * @param method
     */
    private void errorLog(BaseForm zform, HttpServletRequest request, Throwable e, String method) {

        InfoValue info = zform.getValue().getInfo();

        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info,
                "------ Error information ------");
        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info, e);

        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info,
                "------ Input information ------");
        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info,
                logUtil.dump(request.getParameterMap()));

        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info,
                "------ Output information ------");
        logUtil.errorLog(LOG, BaseAction.class.getSimpleName(), method, info,
                logUtil.dump(zform));

    }

    /**
     * Initial for upload file
     *
     * @param zform
     * @throws Exception
     */
    private void initFile(BaseForm zform) throws Exception {
        InfoValue info = zform.getValue().getInfo();
        info.setFile(new ArrayList<FileInfoValue>());
        info.getFile().add(new FileInfoValue());

        FileWriteIF write = zform.getWriteTemp();
        FileReadIF read = zform.getReadTemp();
        FileDeleteIF delete = zform.getDeleteTemp();

        if (write != null) {
            write.setInfo(info);
        }
        if (read != null) {
            read.setInfo(info);
        }
        if (delete != null) {
            delete.setInfo(info);
        }
    }

    /**
     * Copy file to work folder
     *
     * @param form
     * @param zform
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void copyTempFile(ActionForm form, BaseForm zform) throws FileNotFoundException, IOException {
        if (form.getMultipartRequestHandler() != null) {

            InfoValue info = zform.getValue().getInfo();
            int index = 0;
            for (FormFileValue formFile : zform.getFiles()) {
                if (!(formFile.getFile() == null || formFile.getFile().getFileSize() == 0 || Constants.BLANK.equals(formFile.getFormFileName()))) {
                    FileInfoValue fInfo = new FileInfoValue();
                    
                    if (info.getFile().size() <= index) {
                        info.getFile().add(fInfo);
                    } else {
                        info.getFile().set(index, fInfo);
                    }
                    
                    OutputStream ostream = zform.getWriteTemp().write(formFile.getFile().getFileName(), index);
                    streamUtil.copyStream(formFile.getFile().getInputStream(), ostream);
                    
                    fInfo.setUploadFileName(formFile.getFile().getFileName());
                    index++;
                }
            }
        }
    }

    /**
     * get data from session set to object info
     * @param zform
     * @param request
     */
    @SuppressWarnings("unchecked")
    private void copyDataToInfoValue(BaseForm zform, HttpServletRequest request) {

        // set userInfo to object info
        InfoValue info = zform.getValue().getInfo();
        info.setUserInfo(userInfo);

        // get session info
        HttpSession session = request.getSession(false);
        if (session != null) {

            // get session info set to Object Info
            Map<String, Object> sessInfo = (Map<String, Object>) session.getAttribute(Constants.SESSION_INFO);
            if (sessInfo == null) {
                sessInfo = new HashMap<String, Object>();
            }
            info.setMainSessInfo(sessInfo);
        }
    }

    /**
     * Return file to client
     *
     * @param zform
     * @param response
     * @throws Exception
     */
    private void downloadFile(BaseForm zform, HttpServletResponse response) throws Exception {

        InfoValue info = zform.getValue().getInfo();
        String downloadFileName = info.getFile().get(0).getDownloadFileName();
        FileReadIF read = zform.getReadTemp();

        try {
            InputStream istream = read.read(downloadFileName, 0);

            createResponseHeader(zform, response);
            OutputStream ostream = response.getOutputStream();

            streamUtil.copyStream(istream, ostream);
        } catch (IOException e) {
            logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "dowloadFile", info, "Download of the dialog is canceled or communication error" + downloadFileName);
            logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "dowloadFile", info, e);
        } finally {
            zform.getDeleteTemp().delete(downloadFileName, 0);
        }
    }

    /**
     * Set the Response header at the time of download.
     *
     * @param zform
     * @param response
     * @throws Exception
     */
    private void createResponseHeader(BaseForm zform, HttpServletResponse response) throws Exception {

        InfoValue info = zform.getValue().getInfo();
        String downloadFileName = info.getFile().get(0).getDownloadFileName();
        FileReadIF read = zform.getReadTemp();

        if (downloadFileName.toUpperCase().endsWith("HTML") || downloadFileName.toUpperCase().endsWith("HTM")) {
            response.setContentType("text/html");
            addResponseHeaderNoCache(response);
        } else if (downloadFileName.toUpperCase().endsWith("XML")) {
            response.setContentType("text/xml");
            addResponseHeaderNoCache(response);
        } else {
            response.setContentType("application/octet-stream");
            response.setContentLength((int) read.getFileSize(info.getFile().get(0).getDownloadFileName(), 0));
            response.addHeader("Content-disposition", "attachment; filename=\""
                    + new String(downloadFileName.getBytes(Constants.Text.WINDOWS_31J), "ISO-8859-1") + "\"");

        }

    }

    /**
     * Set nocache to response
     *
     * @param response
     */
    private void addResponseHeaderNoCache(HttpServletResponse response) {
        response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:00 GMT, -1");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("Cache-Control", "no-store");
        response.addHeader("Cache-Control", "must-revalidate");
        response.addHeader("Pragma", "no-cache");
    }

    /**
     * Delete upload file
     *
     * @param zform
     */
    private void deleteUploadFile(BaseForm zform) {

        InfoValue info = zform.getValue().getInfo();
        String fileName;

        try {
            int index = 0;
            for (FileInfoValue fileInfo : info.getFile()) {
                fileName = fileInfo.getUploadFileName();
                if (fileName != null) {
                    zform.getDeleteTemp().delete(fileName, index);
                }
                index++;
            }
        } finally {
            for (FormFileValue formFile : zform.getFiles()) {
                if (formFile != null) {
                    formFile.getFile().destroy();
                }
            }
        }
    }

    /**
     * Delete download file
     *
     * @param zform
     * @param response
     * @throws Exception
     */
    protected void deleteDownloadFile(BaseForm zform) throws Exception {

        InfoValue info = zform.getValue().getInfo();
        String fileName;

        try {
            int index = 0;
            for (FileInfoValue fileInfo : info.getFile()) {
                fileName = fileInfo.getDownloadFileName();
                if (fileName != null) {
                    zform.getDeleteTemp().delete(fileName, index);
                }
                index++;
            }
        } finally {
            for (FormFileValue formFile : zform.getFiles()) {
                if (formFile != null) {
                    formFile.getFile().destroy();
                }
            }
        }
    }

    /**
     * build error message set from logic
     *
     * @param zform
     * @param serializeData
     * @param request
     */
    private String createErrorFromLogic(BaseForm zform, byte[] serializeData, HttpServletRequest request) {
        List<Throwable> errorList = msgUtil.getErrorList();
        Iterator<Throwable> ite = errorList.iterator();
        Throwable ex = null;
        String result = SUCCESS_FORWARD;
        String ret = null;

        while (ite.hasNext()) {
            ex = ite.next();
            ret = createErrorMessage(zform, ex, serializeData, request);
            if (ret != null && !"".equals(ret) && !SUCCESS_FORWARD.equals(ret)) {
                result = ret;
            }
        }
        msgUtil.resetErrorList();

        return result;
    }

    /**
     * init error message
     *
     * @param zform
     * @param e
     * @param serializeData
     * @param request
     * @return
     */
    private String createErrorMessage(BaseForm zform, Throwable e, byte[] serializeData, HttpServletRequest request) {
        String result = ERROR_FORWARD;
        Throwable ex = e;
        while (true) {
            if (!(ex instanceof InvocationTargetException)) {
                break;
            }
            if (ex == e.getCause()) {
                break;
            }
            if (e.getCause() != null) {
                ex = e.getCause();
            }
        }

        if (ex instanceof Exception) {

            MSException exc = (MSException) ex;
            setError(zform, exc.getCode(), exc.getParam(), exc.getIdList(), request);
            isResetData = exc.isResetData();

            if (exc.getResult() != null) {
                result = exc.getResult();
            }
            if (SUCCESS_FORWARD.equals(result)) {
                isResetData = false;
            }
        } else {
            setError(zform, Constants.SYSTEM_ERROR_CODE, null, new ArrayList<String>(), request);
            isResetData = true;
        }

        return result;
    }

    /**
     * reset data input
     *
     * @param zform
     * @param serializeData
     * @param request
     */
    private void resetData(BaseForm zform, byte[] serializeData, HttpServletRequest request) {
        try {
            InfoValueIF value = (InfoValueIF) commonUtil.deserialize(serializeData);
            value.getInfo().getItem().getCheckList().clear();
            zform.setValue(value);
            beanUtil.populate(zform.getInputData(), zform);
        } catch (Exception err) {
            errorLog(zform, request, err, "resetData");
        }
    }

    /**
     *
     * Valid struts session
     *
     * @param form
     * @param request
     * @param mapping
     * @return true: valid, false: invalid, display login screen
     */
    private boolean validSession(BaseForm form, HttpServletRequest request, ActionMapping mapping) {

        String param = mapping.getParameter();

        boolean result = false;

        if (param != null && param.contains(PARAM_NO_SESSION)) {
            result = true;
        } else if (param != null && param.contains(PARAM_CREATE_SESSION)) {
            result = true;
        } else if (param != null && param.contains(PARAM_INVALIDATE_SESSION)) {
            result = true;
        } else {
            HttpSession session = request.getSession(false);
            if (session != null) {
                result = true;
            }
        }

        return result;

    }

    /**
     * set error code to BaseForm
     *
     * @param form
     * @param code
     * @param params
     * @param idList
     * @param request
     */
    private void setError(BaseForm form, String code, String[] params, List<String> idList, HttpServletRequest request) {

        String strTmp = code;
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    strTmp += (params[i].indexOf("value.") != -1) ? params[i].substring(params[i].lastIndexOf(".") + 1) : params[i];
                }
            }
        }

        ErrorInfoValue errorValue = form.getError();
        if (errorValue == null || errorValue.getErrorId() == null) {
            errorValue = new ErrorInfoValue();
        }
        if (!errorCheck.containsKey(strTmp)) {
            errorCheck.put(strTmp, 0);
            errorValue.setErrorMessage(msgUtil.getMessage(code, params));
        }
        if (idList == null) {
            idList = new ArrayList<String>();
        }
        if (idList.size() <= 0) {
            idList.add(code);
        }
        errorValue.setIdList(idList);
        form.setError(errorValue);

        request.setAttribute(Constants.ERRORINFO, errorValue);
        logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "setError", form.getValue().getInfo(), errorValue.getErrorMessage());

        if (idList != null) {
            for (int i = 0, n = idList.size(); i < n; i++) {
                logUtil.infoLog(LOG, BaseAction.class.getSimpleName(), "setError", form.getValue().getInfo(),
                        new StringBuffer().append(idList.get(i)).append(",")
                                .append(request.getParameter(idList.get(i))).toString());
            }
        }
    }

    /**
     * Check action with session
     *
     * @param form
     * @param request
     * @param mapping
     */
    private void changeSession(BaseForm form, HttpServletRequest request, ActionMapping mapping) {
        String param = mapping.getParameter();

        if (param != null && param.contains(PARAM_CREATE_SESSION)) {
            // new HTTPSession
            HttpSession session = request.getSession(true);
            session.setAttribute(Constants.SESSION_INFO, form.getValue().getInfo().getMainSessInfo());
            userInfo = new UserInfoValue();
            
        } else if (param != null && (param.contains(PARAM_INVALIDATE_SESSION) || param.contains(PARAM_NO_SESSION))) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute(Constants.SESSION_INFO);
                session.invalidate();
            }
            userInfo = new UserInfoValue();
        } else {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute(Constants.SESSION_INFO, form.getValue().getInfo().getMainSessInfo());
            }
        }

    }
    
    /**
     * process paging before action
     */
    private void processPagingBeforeAction(InfoValue info, HttpServletRequest request) {
        
        String listNumRecord = commonUtil.getValue(Constants.LIST_RECORD_ON_PAGE);
        String recordOnPage = commonUtil.getValue(Constants.DEFAULT_RECORD_ON_PAGE);
        
        // init page
        if (info.getPage().getListNumRecord().size() <= 0) {
            info.getPage().setListNumRecord(listNumRecord);
        }
        if (info.getPage1().getListNumRecord().size() <= 0) {
            info.getPage1().setListNumRecord(listNumRecord);
        }
        if (info.getPage2().getListNumRecord().size() <= 0) {
            info.getPage2().setListNumRecord(listNumRecord);
        }
        if (info.getPage3().getListNumRecord().size() <= 0) {
            info.getPage3().setListNumRecord(listNumRecord);
        }

        info.getPage().setHyojiKensu(info.getPage().getHyojiKensu() <= 0 ? Integer.parseInt(recordOnPage) : info.getPage().getHyojiKensu());
        info.getPage1().setHyojiKensu(info.getPage1().getHyojiKensu() <= 0 ? Integer.parseInt(recordOnPage) : info.getPage1().getHyojiKensu());
        info.getPage2().setHyojiKensu(info.getPage2().getHyojiKensu() <= 0 ? Integer.parseInt(recordOnPage) : info.getPage2().getHyojiKensu());
        info.getPage3().setHyojiKensu(info.getPage3().getHyojiKensu() <= 0 ? Integer.parseInt(recordOnPage) : info.getPage3().getHyojiKensu());
    }

    
    /**
     * process paging after action
     */
    private void processPagingAfterAction(InfoValue info, HttpServletRequest request) {
        
    }
    
    /**
     * get paging object
     * 
     * @param zForm
     * @param request
     * @return
     */
    private PageInfoValue getPaging(BaseForm zForm, HttpServletRequest request) {
        String page = "";
        PageInfoValue paging = new PageInfoValue();
        if (!strUtil.isNull(request.getParameter("paging"))) {
            page = request.getParameter("paging");
        }
        switch (page) {
            case LIST_PAGE_ONE:
                paging = ((InfoValueIF) zForm.getValue()).getInfo().getPage1();
                break;
            case LIST_PAGE_TWO:
                paging = ((InfoValueIF) zForm.getValue()).getInfo().getPage2();
                break;
            case LIST_PAGE_THREE:
                paging = ((InfoValueIF) zForm.getValue()).getInfo().getPage3();
                break;
            default:
                paging = ((InfoValueIF) zForm.getValue()).getInfo().getPage();
                break;
        }
        return paging;
    }
}
