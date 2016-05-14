/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Value class contain info file upload
 *
 */
public class FileInfoValue implements Serializable {
    
    private static final long serialVersionUID = -6375496642263408486L;

    /**
     * object contain file name when upload
     */
    private Map<String, String> tempNameMap = new HashMap<String, String>();

    /**
     * file name to down load 
     */
    private String downloadFileName = null;
    
    /**
     * file name when upload file
     */
    private String uploadFileName = null;
    
    /**
     * flag check download after
     */
    private Boolean downloadAfter = false;

    /**
     * get uploadFileName
     * @return uploadFileName
     */
    public String getUploadFileName() {
        return uploadFileName;
    }

    /**
     * set uploadFileName
     * @param uploadFileName
     */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    /**
     * get downloadFileName
     * @return downloadFileName
     */
    public String getDownloadFileName() {
        return downloadFileName;
    }

    /**
     * set downloadFileName
     * @param downloadFileName
     */
    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    /**
     * get tempFileName
     * @return tempFileName
     */
    public String getTempFileName(String realFileName) {
        return tempNameMap.get(realFileName);
    }
    /**
     * put tempFile with key is realFile to tempNameMap
     * 
     * @param realFileName
     * @param tempFileName
     */
    public void setTempFileName(String realFileName, String tempFileName) {
        tempNameMap.put(realFileName, tempFileName);
    }

    /**
     * @param downloadAfter the downloadAfter to set
     */
    public void setDownloadAfter(Boolean downloadAfter) {
        this.downloadAfter = downloadAfter;
    }

    /**
     * @return the downloadAfter
     */
    public Boolean getDownloadAfter() {
        return downloadAfter;
    }

}