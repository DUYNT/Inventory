package com.tecapro.inventory.store.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("StoreValue")
@Scope("request")
public class StoreValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private StoreResultValue resultValue = new StoreResultValue();

    public StoreResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(StoreResultValue resultValue) {
        this.resultValue = resultValue;
    }
}
