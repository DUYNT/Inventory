/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.logic;

import java.util.List;

import com.tecapro.inventory.common.bean.InfoValue;

public interface GenericLogic {

    /**
     * Print CSV and download
     * @param headers
     * @param data
     * @param prefixFileName
     * @param info
     * @return
     *      return TRUE if can download
     * @throws Throwable
     */
    boolean printCSV(String[] headers, List<String[]> data, String prefixFileName, InfoValue info) throws Throwable;

    /**
     * Print CSV and download
     * @param headers
     * @param data
     * @param prefixFileName
     * @param ext
     * @param info
     * @return
     *      return TRUE if can download
     * @throws Throwable
     */
    boolean printCSV(String[] headers, List<String[]> data, String prefixFileName, String ext, InfoValue info) throws Throwable;

    /**
     * Export CSV file into folder work and return file name
     * @param headers
     * @param data
     * @param prefixFileName
     * @param ext
     * @param info
     * @return
     *      return file name
     * @throws Throwable
     */
    String printCSV(String[] headers, List<String[]> data, String prefixFileName, String ext) throws Throwable;

    /**
     * Export CSV file into folder work and return file name
     * @param headers
     * @param data
     * @param prefixFileName
     * @param info
     * @return
     *      return file name
     * @throws Throwable
     */
    String printCSV(String[] headers, List<String[]> data, String prefixFileName) throws Throwable;

    /**
     * set file to download
     * @param fileName
     * @param info
     * @return
     *      return TRUE if can download
     */
    boolean allowDownloadFile(String fileName, InfoValue info);

}
