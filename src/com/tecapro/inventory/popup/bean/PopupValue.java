package com.tecapro.inventory.popup.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * HomeValue class archive info screen Home
 */
@Component("PopupValue")
@Scope("request")
public class PopupValue extends BaseValue implements InfoValueIF, Serializable {
   
    private static final long serialVersionUID = -1293921997034677773L;
}
