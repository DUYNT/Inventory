package com.tecapro.inventory.home.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;

/**
 * HomeValue class archive info screen Home
 */
@Component("HomeValue")
@Scope("request")
public class HomeValue extends BaseValue implements InfoValueIF, Serializable {
   
    private static final long serialVersionUID = -1293921997034677773L;
//    
//    private String msg;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//    
//    
}
