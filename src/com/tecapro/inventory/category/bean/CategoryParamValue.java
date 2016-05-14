package com.tecapro.inventory.category.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("CategoryParamValue")
@Scope("request")
public class CategoryParamValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1839089497498775772L;
    
    private String thukho;
    
    private String tenPhanKho;

    public String getThukho() {
        return thukho;
    }

    public void setThukho(String thukho) {
        this.thukho = thukho;
    }

    public String getTenPhanKho() {
        return tenPhanKho;
    }

    public void setTenPhanKho(String tenPhanKho) {
        this.tenPhanKho = tenPhanKho;
    }
    
    
}
