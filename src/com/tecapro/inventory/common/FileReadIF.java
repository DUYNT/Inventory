/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface FileReadIF extends InfoValueIF {

    /**
     * init InputStream to read data of file
     * 
     * @param name
     *      file name
     * @return
     *      InputStream object
     */
    InputStream read(String name, int index);

    /**
     * check file readable
     * @return
     *      true: read is OK. true: read is NG
     */
    boolean isReadable(String name, int index);

    /**
     * get size of file
     * @param name
     *      file name
     * @return
     *      size of file
     */
    long getFileSize(String name, int index);
    
    /**
     * Separate of CSV file (default is TAB [\t] format)
     * @param cvsSeparate
     */
    void setCvsSeparate(String cvsSeparate);
    
    /**
     * read file CSV
     * 
     * @param name
     *      file name
     * @return
     *      file info 
     * @throws IOException
     */
    List<String[]> readCSV(String name, int index) throws IOException;

    /**
     * get base dir
     * @return
     */
    String getBaseDir();
    
    /**
     * set basedir
     * @param baseDir
     */
    void setBaseDir(String baseDir);

}