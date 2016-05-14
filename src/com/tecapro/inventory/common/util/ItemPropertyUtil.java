/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.bean.ItemValidationInfoValue;

/**
 * Item properties util class
 *
 */
@Component("ItemPropertyUtil")
public class ItemPropertyUtil {
    
    /**
     * instance of ItemCheckUtil
     */
    @Autowired
    private ItemCheckUtil itemCheckUtil;
    
    /**
     * instance of CommonUtil
     */
    @Autowired
    private CommonUtil commonUtil;

    private static final String CHECK_LIST_NAME = "iteminfo.tsv";

    private static Map<String, ItemValidationInfoValue> paramMap = new HashMap<String, ItemValidationInfoValue>();

    /**
     * Init property for class
     *
     */
    protected enum TSV {
        INDEX(0), DBCOLUMN(1), PROPERTY(2), USE(3), ALPH(4), NUM(5), CODE(6), KANA(7), FULLWIDTH(8), LENGTHMAX(9), LENGTHMIN(10), NUMMAX(11), NUMMIN(12), NUMSEISULENGTH(
                13), NUMSHOSULENGTH(14), FORMAT(15);

        private int index;

        TSV(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    /**
     * create info value
     * 
     * @param tsv
     * @return
     */
    private ItemValidationInfoValue createInfoValue(String tsv) {
        String[] items = tsv.split("\t", 30);

        ItemValidationInfoValue param = new ItemValidationInfoValue();

        param.setIndex(Long.valueOf(items[TSV.INDEX.getIndex()]));
        param.setDbColumn(items[TSV.DBCOLUMN.getIndex()]);
        param.setProperty(items[TSV.PROPERTY.getIndex()]);
        param.setUse(Constants.ONE.equals(items[TSV.USE.getIndex()]) ? true : false);
        param.setAlph(Constants.ONE.equals(items[TSV.ALPH.getIndex()]) ? true : false);
        param.setNum(Constants.ONE.equals(items[TSV.NUM.getIndex()]) ? true : false);
        param.setCode(Constants.ONE.equals(items[TSV.CODE.getIndex()]) ? true : false);
        param.setKana(Constants.ONE.equals(items[TSV.KANA.getIndex()]) ? true : false);
        param.setFullwidth(Constants.ONE.equals(items[TSV.FULLWIDTH.getIndex()]) ? true : false);
        param.setLengthMax(!Constants.BLANK.equals(items[TSV.LENGTHMAX.getIndex()]) ? Long.valueOf(items[TSV.LENGTHMAX.getIndex()]) : null);
        param.setLengthMin(!Constants.BLANK.equals(items[TSV.LENGTHMIN.getIndex()]) ? Long.valueOf(items[TSV.LENGTHMIN.getIndex()]) : null);
        param.setNumMax(!Constants.BLANK.equals(items[TSV.NUMMAX.getIndex()]) ? new BigDecimal(items[TSV.NUMMAX.getIndex()]) : null);
        param.setNumMin(!Constants.BLANK.equals(items[TSV.NUMMIN.getIndex()]) ? new BigDecimal(items[TSV.NUMMIN.getIndex()]) : null);
        param.setNumSeisuLength(!Constants.BLANK.equals(items[TSV.NUMSEISULENGTH.getIndex()]) ? Integer.valueOf(items[TSV.NUMSEISULENGTH.getIndex()]) : null);
        param.setNumShosuLength(!Constants.BLANK.equals(items[TSV.NUMSHOSULENGTH.getIndex()]) ? Integer.valueOf(items[TSV.NUMSHOSULENGTH.getIndex()]) : null);
        param.setFormat(items[TSV.FORMAT.getIndex()]);

        return param;
    }

    public void init() throws IOException, Exception {

        InputStream istream = null;
        BufferedReader reader = null;


        try {

            istream = Thread.currentThread().getContextClassLoader().getResourceAsStream(CHECK_LIST_NAME);
            reader = new BufferedReader(commonUtil.createInputStreamReader(istream));

            if (reader.ready()) {
                reader.readLine(); 
            }

            while (reader.ready()) {
                String line = reader.readLine();
                ItemValidationInfoValue infoValue = createInfoValue(line);
                if (paramMap.containsKey(infoValue.getProperty())) {
                    throw new Exception("Duplicate item [" + infoValue.getProperty() + "] in file [" + CHECK_LIST_NAME + "]!");
                }
                paramMap.put(infoValue.getProperty(), infoValue);
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (istream != null) {
                try {
                    istream.close();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        
        itemCheckUtil.init();
    }


    public ItemValidationInfoValue getItemInfo(String property) {

        int index = property.lastIndexOf(".");

        String key = null;
        if (index < 0) {
            key = property;
        } else {
            key = property.substring(property.lastIndexOf(".") + 1);
        }

        return paramMap.get(key);
    }

}
