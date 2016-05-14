/**
 * 
 */
package com.tecapro.inventory.login.logic;

import java.util.List;

import com.tecapro.inventory.common.logic.GenericLogic;
import com.tecapro.inventory.common.model.Admin;


/**
 * interface LoginLogic class
 * 
 */
public interface LoginLogic extends GenericLogic {

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
