package com.tecapro.inventory.inventory.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("InventoryValue")
@Scope("request")
public class InventoryValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private InventoryResultValue resultValue = new InventoryResultValue();

    public InventoryResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(InventoryResultValue inventoryResultValue) {
        this.resultValue = inventoryResultValue;
    }
    
    
}
