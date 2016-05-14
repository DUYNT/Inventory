/**
 * 
 */
package com.tecapro.inventory.login.dao;

import java.util.List;

import com.tecapro.inventory.common.model.Admin;


/**
 * Dao interface for LoginDaoImpl
 */
public interface LoginDao {

    /**
     * get list user
     * 
     * @return
     */
    List<Admin> getAllUsers();
    
    /**
     * get user
     * 
     * @return
     */
    Admin getUser(Admin user);
    
}
