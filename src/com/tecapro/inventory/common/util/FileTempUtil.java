/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.bean.InfoValue;


public class FileTempUtil extends FileLocalUtil implements FileReadIF, FileWriteIF, FileDeleteIF {

    /**
     * init object Log
     */
    private Log log = LogFactory.getLog(FileLocalUtil.class);

    /**
     * base dir
     */
    private String baseDir = null;
    

    private static final LinkedList<File> deleteFileList = new LinkedList<File>();

    public OutputStream write(String name, int index) {

        try {
            File writeFile = File.createTempFile("TMP", "", new File(getBaseDir()));
            setTempName(name, writeFile.getName(), index);

            return new FileOutputStream(new File(getBaseDir(), writeFile.getName()));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    /**
     * instance of InfoValue
     */
    private InfoValue info = null;
    

    /**
     * get instance of InfoValue
     */
    public InfoValue getInfo() {
        return info;
    }

    /**
     * set instance of InfoValue
     */
    public void setInfo(InfoValue info) {
        this.info = info;
    }

    /**
     * get instance object Log
     */
    public Log getLog() {
        return log;
    }

    /**
     * set instance object Log
     */
    public void setLog(Log log) {
        this.log = log;
    }

    /**
     * get base dir
     */
    public String getBaseDir() {
        return baseDir;
    }

    /**
     * set base dir
     */
    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    /**
     * check file writable
     */
    public boolean isWritable(String name, int index) {
        if (name == null) {
            return true;
        }
        File file = new File(baseDir, getTempName(name, index));
        return !file.exists() || file.canWrite();
    }

    public void delete(String name, int index) {
        synchronized (deleteFileList) {
            deleteFileList.offer(new File(baseDir, getTempName(name, index)));
        }

        deleteFileList();
    }


    public void deleteFileList() {

        boolean endFlag = false;

        while (!endFlag) {

            File file = null;

            synchronized (deleteFileList) {
                file = deleteFileList.poll();
                endFlag = deleteFileList.size() == 0;
            }

            if (!file.exists()) {
                continue;
            }
            if (!file.delete()) {
                synchronized (deleteFileList) {
                    deleteFileList.offer(file);
                }
            }
        }
    }

    public void clear(String baseDir, FileFilter filter) {

        {
            File[] files = new File(baseDir).listFiles(filter);

            for (int i = 0, n = files.length; i < n; i++) {
                files[i].delete();
            }
        }
    }

    /**
     * check file deleteable
     */
    public boolean isDeletable(String name, int index) {
        File file = new File(baseDir, getTempName(name, index));
        return file.isFile() && file.canWrite();
    }

    /**
     * check file readable
     */
    public boolean isReadable(String name, int index) {
        File file = new File(baseDir, getTempName(name, index));
        return file.isFile() && file.canRead();
    }

    /**
     * read file
     * @return 
     *      InputStream
     */
    public InputStream read(String name, int index) {
        try {
            return new FileInputStream(new File(baseDir, getTempName(name, index)));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
    
    /**
     * read data CSV
     * @see com.tecapro.inventory.common.util.FileLocalUtil.splitCSV(String)
     * @return 
     *      List<String[]> data of file
     */
    public List<String[]> readCSV (String name, int index) throws IOException {
        
        String csvFile = baseDir +"/"+ getTempName(name, index);
        List<String[]> list = this.splitCSV(csvFile);
        
        return list;
    }

    /**
     * get file size
     * @return 
     *      byte of file
     */
    public long getFileSize(String name, int index) {
        File file = new File(baseDir, getTempName(name, index));
        return file.length();
    }

    /**
     * get Temp name
     * @param name
     * @return
     *      temp file name
     */
    private String getTempName(String name, int index) {
        return getInfo().getFile().get(index).getTempFileName(name);
    }

    /**
     * set Temp name
     * @param name
     * @param tempName
     */
    private void setTempName(String name, String tempName, int index) {
        getInfo().getFile().get(index).setTempFileName(name, tempName);
    }

}
