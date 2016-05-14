/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecapro.inventory.common.FileDeleteIF;
import com.tecapro.inventory.common.FileReadIF;
import com.tecapro.inventory.common.FileWriteIF;
import com.tecapro.inventory.common.bean.FileInfoValue;
import com.tecapro.inventory.common.bean.InfoValue;

/**
 * File local utill class
 *
 */
public class FileLocalUtil implements FileReadIF, FileWriteIF, FileDeleteIF {

    private Log log = LogFactory.getLog(FileLocalUtil.class);

    private InfoValue info = null;
    private File writeFile = null;
    private String baseDir = null;
    private String tempDir = null;
    private String cvsSeparate = ",";

    /**
     * instance of LogUtil
     */
    @Autowired
    protected LogUtil logUtil;
    
    /**
     * instance of StreamUtil
     */
    @Autowired
    protected StreamUtil streamUtil;

    public InfoValue getInfo() {
        return info;
    }

    /**
     * set InfoValue object
     */
    public void setInfo(InfoValue info) {
        this.info = info;
    }

    /**
     * get object Log
     * @return
     */
    public Log getLog() {
        return log;
    }

    /**
     * set object Log
     * @param log
     */
    public void setLog(Log log) {
        this.log = log;
    }

    /**
     * get Absolute path file
     */
    public String getWriteFilePath(String name) {
        return new File(baseDir, name).getAbsolutePath();
    }

    /**
     * get base dir
     * @return
     */
    public String getBaseDir() {
        return baseDir;
    }

    /**
     * set base dir
     * @param baseDir
     */
    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    /**
     * @return the tempDir
     */
    public String getTempDir() {
        return tempDir;
    }

    /**
     * @param tempDir the tempDir to set
     */
    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    /**
     * set separate CSV format
     */
    public void setCvsSeparate(String cvsSeparate) {
        this.cvsSeparate = cvsSeparate;
    }

    /**
     * get separate CSV format
     * @return
     *      separate of CSV
     */
    public String getCvsSeparate() {
        return cvsSeparate;
    }

    /**
     * check file Writable
     */
    public boolean isWritable(String name, int index) {
        if (name == null) {
            return true;
        }
        File file = new File(baseDir, name);
        return !file.exists() || file.canWrite();
    }

    public OutputStream write(String name, int index) {

        try {
            writeFile = new File(baseDir, name);

            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }

            OutputStream result = new FileOutputStream(new File(baseDir, writeFile.getName()));

            logUtil.infoLog(log, FileLocalUtil.class.getSimpleName(), "write", info, "path:" + writeFile.getAbsolutePath());

            return result;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * delete file
     */
    public void delete(String name, int index) {
        File file = new File(baseDir, name);

        if (!isDeletable(name, index) || !file.delete()) {
            throw new IllegalStateException();
        }

        logUtil.infoLog(log, FileLocalUtil.class.getSimpleName(), "delete", info, "path:" + file.getAbsolutePath());
    }

    /* (non-Javadoc)
     * @see com.tecapro.inventory.common.FileWrite#saveFile()
     */
    public Boolean saveFile() throws IOException {
        
        boolean result = true;
        String realFileName = "";
        String tempFileName = "";
        int index = 0;
        InfoValue info = getInfo();
        String[] removeFile = new String[info.getFile().size()];
        
        try {
            for (FileInfoValue file : info.getFile()) {
                realFileName = file.getUploadFileName();
                tempFileName = file.getTempFileName(realFileName);
                if (tempFileName != null) {
                    
                    InputStream is = new FileInputStream(new File(tempDir, info.getFile().get(index).getTempFileName(realFileName)));
                    OutputStream os = this.write(realFileName, index);
        
                    // Copy to upload folder
                    streamUtil.copyStream(is, os);
                    removeFile[index] = realFileName;
        
                } else {
                    result = false;
                    break;
                }
                index++;
            }
        } catch (Exception e) {
            //delete uploaded when error here
            for (int i = 0; i < index; i++) {
                delete(removeFile[i], i);
            }
            result = false; 
        }
        return result;
    }
    
    /* (non-Javadoc)
     * @see com.tecapro.inventory.common.FileWrite#saveFile(String[] upLoadedFiles)
     */
    public Boolean saveFile(String[] upLoadedFiles) throws IOException {
        boolean result = true;
        String realFileName = "";
        String tempFileName = "";
        
        int index = 0;
        InfoValue info = getInfo();
        String[] removeFile = new String[info.getFile().size()];
        
        try {
            for (FileInfoValue file : info.getFile()) {
                realFileName = file.getUploadFileName();
                tempFileName = file.getTempFileName(realFileName);
                if (tempFileName != null) {
                    InputStream is = new FileInputStream(new File(tempDir, info.getFile().get(index).getTempFileName(realFileName)));
                    OutputStream os = this.write(upLoadedFiles[index], index);
        
                    // Copy to upload folder
                    streamUtil.copyStream(is, os);
                    removeFile[index] = upLoadedFiles[index];
                } else {
                    result = false;
                    break;
                }
                index++;
            }
        } catch (Exception e) {
            //delete uploaded when error here
            for (int i = 0; i < index; i++) {
                delete(removeFile[i], i);
            }
            result = false; 
        }
        
        return result;
    }


    /**
     * check file Deletable
     */
    public boolean isDeletable(String name, int index) {
        File file = new File(baseDir, name);
        return file.isFile() && file.canWrite();
    }

    /**
     * check file readable
     */
    public boolean isReadable(String name, int index) {
        File file = new File(baseDir, name);
        return file.isFile() && file.canRead();
    }

    /**
     * read file
     * @return 
     *      InputStream
     */
    public InputStream read(String name, int index) {
        try {
            File file = new File(baseDir, name);
            InputStream stream = new FileInputStream(file);

            logUtil.infoLog(log, FileLocalUtil.class.getSimpleName(), "read", info, "path:" + file.getAbsolutePath());

            return stream;

        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
    
    /*
     * read data CSV
     * @see com.tecapro.inventory.common.util.FileLocalUtil.splitCSV(String)
     * @return 
     *      List<String[]> data of file
     */
    public List<String[]> readCSV(String name, int index) throws IOException {
        
        String csvFile = baseDir + "/" + name;
        List<String[]> list = this.splitCSV(csvFile);
        
        return list;
    }
    
    /**
     * get content of file and split per line 
     * @param csvFile
     * @return
     * @throws IOException
     */
    protected List<String[]> splitCSV(String csvFile) throws IOException {
        BufferedReader br = null;
        String line = "";
        List<String[]> list = new ArrayList<String[]>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), Constants.Text.WINDOWS_31J));
            if (br != null) {
                
                String match;
                ArrayList<String> allMatches = new ArrayList<String>();
                final Pattern p = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");
                
                while ((line = br.readLine()) != null) {
                    if (line != null && !"".equals(line)) {
                        
                        int size;
                        Matcher m = p.matcher(line);
                        allMatches.clear();
                        while (m.find()) {
                            match = m.group(1);
                            if (match != null) {
                                allMatches.add(match);
                            } else {
                                allMatches.add(m.group(2));
                            }
                        }
                        size = allMatches.size();
                        if (size > 0) {
                            list.add(allMatches.toArray(new String[size]));
                        }
                    }
                }
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return list;
    }

    /**
     * get file size
     * @return 
     *      byte of file
     */
    public long getFileSize(String name, int index) {
        File file = new File(baseDir, name);
        return file.length();
    }
    
    /**
     * Zip file
     * @param srcPath: source file
     * @param dtsPath: destination zip file
     * @param password: zip file password
     * @return
     * @throws ZipException
     */
    public boolean zipFile(String srcPath, String dtsPath, String password) throws ZipException {
        boolean result = true;
        try {
            // filePath = srcPath
            ZipFile zipFile = new ZipFile(dtsPath);
            File srcFile = new File(srcPath);
            ZipParameters parameters = new ZipParameters();

            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            if (password != null && !"".equals(password.trim())) {
                parameters.setEncryptFiles(true);
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                parameters.setPassword(password);
            }
            zipFile.addFile(srcFile, parameters);
        } catch (Throwable e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
    
    /**
     * multipart zip files
     * 
     * @param srcPath: source file
     * @param dtsPath: destination zip file
     * @param password: zip file password
     * @return
     * @throws ZipException
     */
    public boolean zipFiles(List<String> srcPaths, String dtsPath, String password) throws ZipException {
        boolean result = true;
        try {
            // filePath = srcPath
            ZipFile zipFile = new ZipFile(dtsPath);
            ZipParameters parameters = new ZipParameters();

            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            if (password != null && !"".equals(password.trim())) {
                parameters.setEncryptFiles(true);
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                parameters.setPassword(password);
            }
            
            for (String srcPath : srcPaths) {
                zipFile.addFile(new File(srcPath), parameters);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    @Override
    public void setDownloadFile(String name) throws IOException {
        // not implement
        
    }

}
