/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import net.lingala.zip4j.exception.ZipException;

public interface FileWriteIF extends InfoValueIF {

    /**
     * get file path
     * @return 
     *      String FilePath
     */
    String getWriteFilePath(String name);

    /**
     * init OutputStream to write data into file
     *  
     * @param name
     * @return
     *      OutputStream object
     */
    OutputStream write(String name, int index);

    /**
     * check file writable
     * @return
     *      true: write is OK. true: write is NG
     */
    boolean isWritable(String name, int index);
    
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
    
    /**
     * Save file into upload folder
     * 
     * @param readIF
     * @return
     * @throws IOException
     */
    Boolean saveFile() throws IOException;
    
    /**
     * Save file into upload folder with fileName in upLoadedFiles
     * 
     * @param upLoadedFiles
     * @return
     * @throws IOException
     */
    Boolean saveFile(String[] upLoadedFiles) throws IOException;
    
    /**
     * Zip file
     * @param srcPath: source file
     * @param dtsPath: destination zip file
     * @param password: zip file password
     * @return
     * @throws ZipException
     */
    boolean zipFile(String srcPath, String dtsPath, String password) throws ZipException;
    
    /**
     * multipart zip files
     * 
     * @param srcPath: source file
     * @param dtsPath: destination zip file
     * @param password: zip file password
     * @return
     * @throws ZipException
     */
    boolean zipFiles(List<String> srcPaths, String dtsPath, String password) throws ZipException;
    
    /**
     * Set file to download
     * 
     * @param name
     * @throws IOException
     */
    void setDownloadFile(String name) throws IOException;

}
