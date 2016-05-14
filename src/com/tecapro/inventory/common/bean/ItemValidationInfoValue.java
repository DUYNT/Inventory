/*
* Copyright 2016 Tecapro. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.tecapro.inventory.common.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Load CSV to the list of this class for validation
 * 
 */
public class ItemValidationInfoValue implements Serializable {
    
    private static final long serialVersionUID = -2569048220523249065L;

    /**
     * row index
     */
    private Long index = null;
    
    /**
     * conlumn name
     */
    private String dbColumn = null;
    
    private String property = null;
    
    private boolean use = false;
    
    private boolean alph = false;
    
    private boolean num = false;
    
    private boolean code = false;
    
    private boolean kana = false;
    
    private boolean fullwidth = false;
    
    private Long lengthMax = null;
    
    private Long lengthMin = null;
    
    private BigDecimal numMax = null;
   
    private BigDecimal numMin = null;
    
    private Integer numSeisuLength = 0;
    
    private Integer numShosuLength = 0;
    
    private String format = null;
    
    private boolean require = false;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getDbColumn() {
        return dbColumn;
    }

    public void setDbColumn(String dbColumn) {
        this.dbColumn = dbColumn;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public boolean isAlph() {
        return alph;
    }

    public void setAlph(boolean alph) {
        this.alph = alph;
    }

    public boolean isNum() {
        return num;
    }

    public void setNum(boolean num) {
        this.num = num;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public boolean isKana() {
        return kana;
    }

    public void setKana(boolean kana) {
        this.kana = kana;
    }

    public boolean isFullwidth() {
        return fullwidth;
    }

    public void setFullwidth(boolean fullwidth) {
        this.fullwidth = fullwidth;
    }

    public Long getLengthMax() {
        return lengthMax;
    }

    public void setLengthMax(Long lengthMax) {
        this.lengthMax = lengthMax;
    }

    public Long getLengthMin() {
        return lengthMin;
    }

    public void setLengthMin(Long lengthMin) {
        this.lengthMin = lengthMin;
    }

    public BigDecimal getNumMax() {
        return numMax;
    }

    public void setNumMax(BigDecimal numMax) {
        this.numMax = numMax;
    }

    public BigDecimal getNumMin() {
        return numMin;
    }

    public void setNumMin(BigDecimal numMin) {
        this.numMin = numMin;
    }

    public Integer getNumSeisuLength() {
        return numSeisuLength;
    }

    public void setNumSeisuLength(Integer numSeisuLength) {
        this.numSeisuLength = numSeisuLength;
    }

    public Integer getNumShosuLength() {
        return numShosuLength;
    }

    public void setNumShosuLength(Integer numShosuLength) {
        this.numShosuLength = numShosuLength;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}