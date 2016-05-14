/**
 * 
 */
package com.tecapro.inventory.login.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecapro.inventory.common.logic.impl.GenericLogicImpl;
import com.tecapro.inventory.common.model.Admin;
import com.tecapro.inventory.login.dao.LoginDao;
import com.tecapro.inventory.login.logic.LoginLogic;

/**
 * Process Logic for Login
 * 
 */
@Service("LoginLogic")
public class LoginLogicImpl extends GenericLogicImpl implements LoginLogic {

    /** Instance of LoginDao */
    @Autowired
    private LoginDao loginDao;

    /*
     * (non-Javadoc)
     * @see com.tecapro.inventory.login.logic.LoginLogic#getAllUsers()
     */
    @Override
    public List<Admin> getAllUsers() {
        return loginDao.getAllUsers();
    }

    @Override
    public Admin getUser(Admin user) {
        return loginDao.getUser(user);
    }
    
}
