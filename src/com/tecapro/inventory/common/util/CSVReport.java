/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.exception.FileException;

/**
 * CSV Util class
 *
 */
@Component("CSVReport")
public class CSVReport {
    
    private static final String REPORT_FILE_EXT = ".csv";
    private static final String FILE_PATH_WORK_PROPERTY = "filepath.temp";
    
    private static final String SEPERATOR_STRING = ",";

    public static final String WIN_NEW_LINE_CRLF = "\r\n";
    
    private static final String CSV_ENCODE = "CSV_ENCODE";
    
    /**
     * instance of CommonUtil
     */
    @Autowired
    private CommonUtil commonUtil;
    
    /**
     * instance of StringUtil
     */
    @Autowired
    private StringUtil strUtil;
    
    /**
     * instance of PropertiesUtil
     */
    @Autowired
    private PropertiesUtil propUtil;
    
    /**
     * instance of DateUtil
     */
    @Autowired
    private DateUtil dateUtil;

    /**
     * Export CSV format with extension file
     * 
     * @param fileName
     * @param ext
     *      Extension file
     * @param header
     *      row header
     * @param dataLines
     * @return
     *      CSV file name
     * @throws FileException 
     */
    public String exportReportToCsvFile(String fileName, String ext, String[] headers, List<String[]> dataLines) throws FileException {
        String uuid = dateUtil.convertDateToString(Calendar.getInstance().getTime(), 
                DateUtil.FORMAT_YEAR_MONTH_DAY_FULL_TIME);
        return exportCsv(fileName, uuid, ext, headers, dataLines);
    }

    /**
     * Export CSV format with prefix format file
     * 
     * @param fileName
     * @param format
     *      Format file [1: yyyyMMdd]
     * @param header
     *      row header
     * @param dataLines
     * @return
     *      CSV file name
     * @throws FileException 
     */
    public String exportReportToCsvWithFormatFile(String fileName, int format, String[] headers, List<String[]> dataLines) throws FileException {
        String postFormat = "";
        switch (format) {
            case 1:
                postFormat = DateUtil.FORMAT_YEAR_MONTH_DAY;
                break;

            default:
                postFormat = DateUtil.FORMAT_YEAR_MONTH_DAY_FULL_TIME;
                break;
        }
        if ("".equals(postFormat)) {
            postFormat = DateUtil.FORMAT_YEAR_MONTH_DAY_FULL_TIME;
        }
        String uuid = dateUtil.convertDateToString(Calendar.getInstance().getTime(), postFormat);
        return exportCsv(fileName, uuid, REPORT_FILE_EXT, headers, dataLines);
    }

    /**
     * Export CSV format with prefix, extension default [.csv]
     * 
     * @param fileName
     * @param header
     *      row header
     * @param dataLines
     * @return
     *      CSV file name
     * @throws FileException 
     */
    public String exportReportToCsvFile(String fileName, String[] headers, List<String[]> dataLines) throws FileException {
        return exportReportToCsvWithFormatFile(fileName, 0, headers, dataLines);
    }

    /**
     * Export CSV file
     * 
     * @param fileName
     * @param prefix
     *      Prefix file
     * @param ext
     *      Extension file
     * @param header
     *      row header
     * @param dataLines
     * @return
     *      CSV file name
     * @throws FileException 
     */
    private String exportCsv(String fileName, String prefix, String ext, String[] headers, List<String[]> dataLines) throws FileException {
        String reportFileName = StringUtils.EMPTY;
        String reportPathDest = StringUtils.EMPTY;
        
        // Get report file name
        reportFileName = String.format("%s_%s%s", fileName, prefix, ext);

        // Get path work folder
        reportPathDest = propUtil.getPathProperty(FILE_PATH_WORK_PROPERTY) + File.separator;
        
        try {
            FileOutputStream fos = new FileOutputStream(reportPathDest + reportFileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos , commonUtil.getValue(CSV_ENCODE));
            BufferedWriter bw = new BufferedWriter(osw);
            
            if (headers != null && headers.length > 0) {
                String header = createLineData(headers);
                bw.write(header); 
                bw.write(WIN_NEW_LINE_CRLF);
            }
    
            Iterator<?> ite = dataLines.iterator();
            String lineData;
            while (ite.hasNext()) {
                String[] nestList = (String[]) ite.next();
                lineData = createLineData(nestList);
                bw.write(lineData);
    
                bw.write(WIN_NEW_LINE_CRLF);
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            throw new FileException(e.getCause());
        }

        return reportFileName;
    }

    private String createLineData(String[] list) throws Exception {
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        
        for (String str : list) {
            if (!strUtil.isNull(str)) {
                if (str.indexOf(SEPERATOR_STRING) != -1) {
                    sb.append("\"").append(str).append("\"");
                } else {
                    sb.append(str);
                }
            }
            cnt++;
            if (cnt < list.length) {
                sb.append(SEPERATOR_STRING);
            }
        }
        return sb.toString();
    }
    
}
