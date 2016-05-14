package com.tecapro.inventory.authorities.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * AuthoritiesValue class archive info screen Authorities
 */
@Component("AuthoritiesValue")
@Scope("request")
public class AuthoritiesValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private AuthoritiesResultValue resultValue = new AuthoritiesResultValue();

    public AuthoritiesResultValue getResultValue() {
        return resultValue;
    }

    public void setResultValue(AuthoritiesResultValue authoritiesResultValue) {
        this.resultValue = authoritiesResultValue;
    }
    
    
}
