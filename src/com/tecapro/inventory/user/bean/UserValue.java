package com.tecapro.inventory.user.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;
import com.tecapro.inventory.common.model.User;

/**
 * UserValue class archive info screen Total
 */
@Component("UserValue")
@Scope("request")
public class UserValue extends BaseValue implements InfoValueIF, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1609009477266477879L;
   
    private UserResultValue userResultValue = new UserResultValue();
    
    private User user = new User();
    
    private String errMsg = ""; 
    
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserResultValue getResultValue() {
        return userResultValue;
    }

    public void setResultValue(UserResultValue userResultValue) {
        this.userResultValue = userResultValue;
    }
}
