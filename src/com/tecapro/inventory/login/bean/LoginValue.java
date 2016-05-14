package com.tecapro.inventory.login.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tecapro.inventory.common.InfoValueIF;
import com.tecapro.inventory.common.bean.BaseValue;
import com.tecapro.inventory.common.model.User;

/**
 * Src0010Value class archive info screen 0010
 */
@Component("LoginValue")
@Scope("request")
public class LoginValue extends BaseValue implements InfoValueIF, Serializable {

    private static final long serialVersionUID = -8946502465873694287L;
    
    private User user = new User();
    private List<User> userList = new ArrayList<User>();
    private String errorMsg = "";

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList
     *            the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
