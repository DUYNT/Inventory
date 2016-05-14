package com.tecapro.inventory.authorities.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * AuthoritiesParamValue class archive info screen Authorities
 */
@Component("AuthoritiesParamValue")
@Scope("request")
public class AuthoritiesParamValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1839089497498775772L;
}
