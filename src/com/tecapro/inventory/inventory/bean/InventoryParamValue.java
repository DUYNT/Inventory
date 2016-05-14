package com.tecapro.inventory.inventory.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("InventoryParamValue")
@Scope("request")
public class InventoryParamValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1839089497498775772L;
}
