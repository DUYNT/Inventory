package com.tecapro.inventory.user.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * UserResultValue class archive info screen Total
 */
@Component("UserResultValue")
@Scope("request")
public class UserResultValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1819818726720942790L;
    
    private String typeLayout;

    public String getTypeLayout() {
        return typeLayout;
    }

    public void setTypeLayout(String typeLayout) {
        this.typeLayout = typeLayout;
    }
}
