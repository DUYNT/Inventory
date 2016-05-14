/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.apache.struts.action.ActionForm;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.action.DelegateAction;
import com.tecapro.inventory.common.bean.ErrorInfoValue;
import com.tecapro.inventory.common.bean.FormFileValue;
import com.tecapro.inventory.common.bean.ValueFactory;

/**
 * Action form bean class
 * 
 */
public class BaseForm extends ActionForm implements Serializable {

    private static final long serialVersionUID = -5812903469775178873L;

    /**
     * InfoValue object
     */
    private InfoValueIF value;

    /**
     * object Action
     */
    private DelegateAction objAction = null;

    /**
     * string key
     */
    private String valueBase64 = null;

    /**
     * List upload file infor
     */
    @SuppressWarnings("unchecked")
    private List<FormFileValue> files = ListUtils.lazyList(new ArrayList<FormFileValue>(), new ValueFactory(FormFileValue.class));

    /**
     * Temp file
     */
    @Autowired
    private FileWriteIF writeTemp = null;

    /**
     * Read file
     */
    @Autowired
    private FileReadIF readTemp = null;
    /**
     * 
     * Delete file
     */
    @Autowired
    private FileDeleteIF deleteTemp = null;

    /**
     * path when forward
     */
    private String path = null;

    /**
     * object store ParameterMap
     */
    private Map<String, Object> inputData = null;

    /**
     * object contain ErrorInfoValue object
     */
    private ErrorInfoValue error = new ErrorInfoValue();

    /**
     * info message
     */
    private List<String> infoMsg = new ArrayList<String>();

    /**
     * type of request (ajax or browser request)
     */
    private String type = null;

    /**
     * object contain data input
     */
    private HashMap<String, Object> properties = new HashMap<String, Object>();

    /**
     * flag check to set properties when has error
     */
    private Boolean errorFlag = true;

    /**
     * get valueBase64
     * 
     * @return valueBase64
     */
    public String getValueBase64() {
        return valueBase64;
    }

    /**
     * set valueBase64
     * 
     * @param valueBase64
     */
    public void setValueBase64(String valueBase64) {
        this.valueBase64 = valueBase64;
    }

    /**
     * get file
     * 
     * @return file
     */
    public List<FormFileValue> getFiles() {
        return this.files;
    }

    /**
     * set file
     * 
     * @param file
     */
    public void setFile(List<FormFileValue> files) {
        this.files = files;
    }

    /**
     * get write file
     * 
     * @return write
     */
    public FileWriteIF getWriteTemp() {
        return writeTemp;
    }

    /**
     * set write file
     * 
     * @param write
     */
    public void setWriteTemp(FileWriteIF write) {
        this.writeTemp = write;
    }

    /**
     * get read file
     * 
     * @return read
     */
    public FileReadIF getReadTemp() {
        return readTemp;
    }

    /**
     * set read file
     * 
     * @param read
     */
    public void setReadTemp(FileReadIF read) {
        this.readTemp = read;
    }

    
    public FileDeleteIF getDeleteTemp() {
        return deleteTemp;
    }

    
    public void setDeleteTemp(FileDeleteIF delete) {
        this.deleteTemp = delete;
    }

   
    public InfoValueIF getValue() {
        return value;
    }

    
    public void setValue(InfoValueIF value) {
        this.value = value;
    }

   
    public DelegateAction getObjAction() {
        return objAction;
    }


    public void setObjAction(DelegateAction objAction) {
        this.objAction = objAction;
    }

 
    public Map<String, Object> getInputData() {
        return inputData;
    }


    @SuppressWarnings("unchecked")
    public void setInputData(Object inputData) {
        this.inputData = (Map<String, Object>) inputData;
    }


    public ErrorInfoValue getError() {
        return error;
    }


    public void setError(ErrorInfoValue error) {
        this.error = error;
    }


    public void setInfoMsg(List<String> infoMsg) {
        this.infoMsg = infoMsg;
    }

    public List<String> getInfoMsg() {
        return infoMsg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setErrorFlag(Boolean errorFlag) {
        this.errorFlag = errorFlag;
    }

    public Boolean getErrorFlag() {
        return errorFlag;
    }
}
