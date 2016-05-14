package com.tecapro.inventory.category.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("CategoryValue")
@Scope("request")
public class CategoryValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private CategoryResultValue resultValue = new CategoryResultValue();
    
    private CategoryParamValue params = new CategoryParamValue();

    public CategoryResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(CategoryResultValue categoryResultValue) {
        this.resultValue = categoryResultValue;
    }

    public CategoryParamValue getParams() {
        return params;
    }

    public void setParams(CategoryParamValue params) {
        this.params = params;
    }
}
