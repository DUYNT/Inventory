/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.action;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.exception.MSException;
import com.tecapro.inventory.common.util.CheckUtil;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.ConvertUtil;
import com.tecapro.inventory.common.util.DateUtil;
import com.tecapro.inventory.common.util.LogUtil;
import com.tecapro.inventory.common.util.MessageUtil;
import com.tecapro.inventory.common.util.PropertiesUtil;
import com.tecapro.inventory.common.util.ResourceUtil;
import com.tecapro.inventory.common.util.StreamUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * Action class
 *
 */
public class DelegateAction {

    /**
     * init log
     */
    private static final Log LOG = LogFactory.getLog(DelegateAction.class);

    /**
     * instance of InfoValue
     */
    private InfoValue info;
    
    /**
     * action method name
     */
    private String actMethod = null;
    
    /**
     * Object validate
     */
    private Object logicValidate = null;
    
    /**
     * validate method name
     */
    private String valMethod = null;

    /** failure forward */
    protected static final int NUMBER_ARG = 3;

    /** failure forward */
    protected static final String ERROR_FORWARD = "failure";

    /** success forward */
    protected static final String SUCCESS_FORWARD = "success";

    /** continue forward */
    protected static final String CONTINUE_FORWARD = "continue";

    /** finish forward */
    protected static final String FINISH_FORWARD = "finish";

    /** search forward */
    protected static final String SEARCH_FORWARD = "search";

    /** register forward */
    protected static final String REGISTER_FORWARD = "register";

    /** update forward */
    protected static final String EDIT_FORWARD = "edit";

    /** delete forward */
    protected static final String DELETE_FORWARD = "delete";
    
    /**
     * interface to read upload file
     * working BaseDir: filepath.upload
     */
    @Autowired
    protected FileReadIF readUpload = null;

    /**
     * interface to write upload file
     * working BaseDir: filepath.upload
     */
    @Autowired
    protected FileWriteIF writeUpload = null;

    /**
     * interface to delete upload file
     * working BaseDir: filepath.upload
     */
    @Autowired
    protected FileDeleteIF deleteUpload = null;
    
    /**
     * interface to read temp file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileReadIF readTemp = null;
    
    /**
     * interface to write temp file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileWriteIF writeTemp = null;
    
    /**
     * interface to delete temp file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileDeleteIF deleteTemp = null;
    
    /**
     * interface to read download file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileReadIF readDownload = null;
    
    /**
     * interface to write download file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileWriteIF writeDownload = null;
    
    /**
     * interface to delete download file
     * working BaseDir: filepath.temp
     */
    @Autowired
    protected FileDeleteIF deleteDownload = null;
    
    /**
     * instance of ResourceUtil
     */
    @Autowired
    protected ResourceUtil resourceUtil;
    
    /**
     * instance of StringUtil
     */
    @Autowired
    protected StringUtil strUtil;
    
    /**
     * instance of DateUtil
     */
    @Autowired
    protected DateUtil dateUtil;
    
    /**
     * instance of CheckUtil
     */
    @Autowired
    protected CheckUtil checkUtil;
    
    /**
     * instance of ConvertUtil
     */
    @Autowired
    protected ConvertUtil convertUtil;
    
    /**
     * instance of CommonUtil
     */
    @Autowired
    protected CommonUtil commonUtil;
    
    /**
     * instance of MessageUtil
     */
    @Autowired
    protected MessageUtil msgUtil;
    
    /**
     * instance of StreamUtil
     */
    @Autowired
    protected StreamUtil streamUtil;

    /**
     * instance of PropertiesUtil
     */
    @Autowired
    protected PropertiesUtil propUtil;
    
    /**
     * instance of LogUtil
     */
    @Autowired
    protected LogUtil logUtil;
    
    /**
     * invoke custom validate method
     */
    public void validate(String inputVal, String property, Integer idx) throws Throwable {
        
        if (logicValidate != null && !"".equals(valMethod)) {
            long time = startLog();
            
            Class<?>[] typelist = new Class[NUMBER_ARG];
            typelist[0] = String.class;
            typelist[1] = String.class;
            typelist[2] = Integer.class;
            
            Method method = null;
            try {
                
                // get method validate plus
                method = logicValidate.getClass().getMethod(valMethod, typelist);
            } catch (Exception e) {
                logicValidate = null;
                valMethod = "";
            }
            
            if (method != null) {
                // init arguments for method
                Object[] arglist = new Object[NUMBER_ARG];
                arglist[0] = property;
                arglist[1] = inputVal;
                arglist[2] = idx;
                
                // invoke method validate plus
                method.invoke(logicValidate, arglist);
            }
            
            endLog(time);
        }
    }

    /**
     * invoke method action for batch
     * @throws Throwable 
     */
    public String execute(InfoValue info) throws Exception {

        long time = startLog();
        
        String result;
        this.info = info;
        
        // set object info to interface
        readTemp.setInfo(info);
        writeTemp.setInfo(info);
        deleteTemp.setInfo(info);
        readUpload.setInfo(info);
        writeUpload.setInfo(info);
        deleteUpload.setInfo(info);
        readDownload.setInfo(info);
        writeDownload.setInfo(info);
        deleteDownload.setInfo(info);
        
        try {
            // invoke method action
            Method method = this.getClass().getMethod(actMethod, new Class[] {});
            result = (String) method.invoke(this, new Object[] {});
        } catch (Exception ex) {
            if (ex.getCause() instanceof MSException) {
                throw (MSException) ex.getCause();
            } else {
                throw ex;
            }
        }
        endLog(time);
        
        return result;
    }

    /**
     * set name of method action
     * 
     * @param actMethod method name
     */
    public void setActMethod(String actMethod) {
        this.actMethod = actMethod;
    }

    /**
     * get object logic validate
     * 
     * @return object logic validate
     */
    public Object getLogicValidate() {
        return logicValidate;
    }

    /**
     * Set object logic validate
     * @param logicValidate object logic validate
     */
    public void setLogicValidate(Object logicValidate) {
        this.logicValidate = logicValidate;
    }

    /**
     * set name of method validate
     * 
     * @param valMethod method name
     */
    public void setValMethod(String valMethod) {
        this.valMethod = valMethod;
    }

    /**
     * Start log output
     */
    protected long startLog() {
        return logUtil.startLog(LOG, this.getClass().getSimpleName(), actMethod, info);
    }

    /**
     * End log output
     */
    protected void endLog(long startTime) {
        logUtil.endLog(LOG, this.getClass().getSimpleName(), actMethod, info, startTime);
    }
}
