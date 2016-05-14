/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.logic.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.bean.FileInfoValue;
import com.tecapro.inventory.common.bean.InfoValue;
import com.tecapro.inventory.common.logic.GenericLogic;
import com.tecapro.inventory.common.util.CSVReport;
import com.tecapro.inventory.common.util.CheckUtil;
import com.tecapro.inventory.common.util.CommonUtil;
import com.tecapro.inventory.common.util.ConvertUtil;
import com.tecapro.inventory.common.util.DateUtil;
import com.tecapro.inventory.common.util.LogUtil;
import com.tecapro.inventory.common.util.PropertiesUtil;
import com.tecapro.inventory.common.util.ResourceUtil;
import com.tecapro.inventory.common.util.StreamUtil;
import com.tecapro.inventory.common.util.StringUtil;

/**
 * GenericLogic class common
 *
 */
public class GenericLogicImpl implements GenericLogic {

    /**
     * init log
     */
    protected static final Log LOG = LogFactory.getLog(GenericLogicImpl.class);
    
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
     * Instance of CSVReport
     */
    @Autowired
    private CSVReport csvReport;

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
     * (non-Javadoc)
     * @see com.viettel.common.logic.GenericLogic.printCSV(String[], List<String[]>, String, String, InfoValue)
     */
    public boolean printCSV(String[] headers, List<String[]> data, String prefixFileName, String ext, InfoValue info) throws Throwable {

        // create CSV file
        String fileName = printCSV(headers, data, prefixFileName, ext);

        // Download in file work folder
        return this.allowDownloadFile(fileName, info);
    }

    /**
     * (non-Javadoc)
     * @see com.viettel.common.logic.GenericLogic.printCSV(String[], List<String[]>, String, InfoValue)
     */
    public boolean printCSV(String[] headers, List<String[]> data, String prefixFileName, InfoValue info) throws Throwable {

        // create CSV file
        String fileName = printCSV(headers, data, prefixFileName);

        // Download in file work folder
        return this.allowDownloadFile(fileName, info);
    }

    /**
     * (non-Javadoc)
     * @see com.viettel.common.logic.GenericLogic.printCSV(String[], List<String[]>, String, String)
     */
    public String printCSV(String[] headers, List<String[]> data, String prefixFileName, String ext) throws Throwable {
        return csvReport.exportReportToCsvFile(prefixFileName, ext, headers, data);
    }

    /**
     * (non-Javadoc)
     * @see com.viettel.common.logic.GenericLogic.printCSV(String[], List<String[]>, String)
     */
    public String printCSV(String[] headers, List<String[]> data, String prefixFileName) throws Throwable {
        return csvReport.exportReportToCsvFile(prefixFileName, headers, data);
    }

    /**
     * (non-Javadoc)
     * @see com.viettel.common.logic.GenericLogic.allowDownloadFile(String, InfoValue)
     */
    public boolean allowDownloadFile(String fileName, InfoValue info) {

        Boolean ret = true;

        // Download in file work folder
        // Auto delete file after download
        FileInfoValue file = info.getFile().get(0);

        // init 
        readTemp.setInfo(info);
        file.setTempFileName(fileName, fileName);
        if (readTemp.isReadable(fileName, 0)) {
            file.setDownloadFileName(fileName);
        } else {
            ret = false;
        }
        return ret;
    }
    

}
