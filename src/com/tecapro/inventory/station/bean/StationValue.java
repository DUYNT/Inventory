package com.tecapro.inventory.station.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * StationValue class archive info screen Total
 */
@Component("StationValue")
@Scope("request")
public class StationValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private StationResultValue resultValue = new StationResultValue();

    public StationResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(StationResultValue stationResultValue) {
        this.resultValue = stationResultValue;
    }
    
    
}
