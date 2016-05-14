/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

/**
 * Value class contain info file upload
 *
 */
public class FormFileValue implements Serializable {

    private static final long serialVersionUID = -8151836244395846074L;

    private FormFile file = null;
    
    private String formFileName = null;

    /**
     * @return the file
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(FormFile file) {
        this.file = file;
    }

    /**
     * @return the formFileName
     */
    public String getFormFileName() {
        return formFileName;
    }

    /**
     * @param formFileName the formFileName to set
     */
    public void setFormFileName(String formFileName) {
        this.formFileName = formFileName;
    }
    

}