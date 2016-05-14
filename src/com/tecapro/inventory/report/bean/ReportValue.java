package com.tecapro.inventory.report.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * ReportValue class archive info screen Total
 */
@Component("ReportValue")
@Scope("request")
public class ReportValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private ReportResultValue resultValue = new ReportResultValue();

    public ReportResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(ReportResultValue resultValue) {
        this.resultValue = resultValue;
    }
}
