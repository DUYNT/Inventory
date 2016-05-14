/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * File Download Utill class
 *
 */
public class FileDownloadUtil extends FileTempUtil {
    
    private String uploadDir = null;
    
    /**
     * instance of StreamUtil
     */
    @Autowired
    protected StreamUtil streamUtil;

    /**
     * @return the uploadDir
     */
    public String getUploadDir() {
        return uploadDir;
    }

    /**
     * @param uploadDir the uploadDir to set
     */
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    /**
     * (non-Javadoc)
     * @see com.tecapro.inventory.common.util.FileTempUtil.write(String)
     */
    @Override
    public OutputStream write(String name, int index) {
        OutputStream ostream = super.write(name, index);
        getInfo().getFile().get(0).setDownloadFileName(name);

        logUtil.infoLog(getLog(), FileDownloadUtil.class.getSimpleName(), "write", getInfo(), "fileName:" + name);

        return ostream;
    }
    
    public void setDownloadFile(String name) throws IOException {
        try {
            File file = new File(uploadDir, name);
            InputStream is = new FileInputStream(file);
            OutputStream os = this.write(name, 0);
            streamUtil.copyStream(is, os);

        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
    
    

}
