package com.tecapro.inventory.report.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * TotalValue class archive info screen Total
 */
@Component("ReportParamValue")
@Scope("request")
public class ReportParamValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1839089497498775772L;
}
