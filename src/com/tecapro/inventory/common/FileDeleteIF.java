/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common;

public interface FileDeleteIF extends InfoValueIF {

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
     * delete file
     * @param name
     *      file name
     */
    void delete(String name, int index);

    /**
     * check file deletable
     * @return
     *      true: delete is OK. true: delete is NG
     */
    boolean isDeletable(String name, int index);

}