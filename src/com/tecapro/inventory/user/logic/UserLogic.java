/**
 * 
 */
package com.tecapro.inventory.user.logic;

import com.tecapro.inventory.common.model.User;

/**
 * interface TotalLogic class
 * 
 */
public interface UserLogic {
    int updatePassword(User user);
    
    int updateInfo(User user);
}
