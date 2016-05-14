/**
 * 
 */
package com.tecapro.inventory.user.dao;

import com.tecapro.inventory.common.model.User;

/**
 * Dao interface for UserDaoImpl
 */
public interface UserDao {
    int updatePassword(User value);
    
    int updateInfo(User user);
}
