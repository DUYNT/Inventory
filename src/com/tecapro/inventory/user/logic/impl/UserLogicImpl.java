/**
 * 
 */
package com.tecapro.inventory.user.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.common.model.User;
import com.tecapro.inventory.user.dao.UserDao;
import com.tecapro.inventory.user.logic.UserLogic;

/**
 * Dao implement for TotalLogic
 * 
 */
@Repository("UserLogic")
public class UserLogicImpl implements UserLogic {

    @Autowired
    private UserDao dao;
    
    @Override
    public int updatePassword(User user) {
        return dao.updatePassword(user);
    }

    @Override
    public int updateInfo(User user) {
        return dao.updateInfo(user);
    }
}
