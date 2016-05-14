/**
 * 
 */
package com.tecapro.inventory.user.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.common.model.User;
import com.tecapro.inventory.user.dao.UserDao;

/**
 * Dao implement for TotalLogic
 * 
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    private String namespace = "com.tecapro.inventory.user.dao.UserDao";

    @Autowired
    private SqlSession sqlSession;
    
    @Override
    public int updatePassword(User value) {
        String query = namespace + ".updatePassword";
        return sqlSession.update(query, value);
    }

    @Override
    public int updateInfo(User user) {
        String query = namespace + ".updateInfo";
        return sqlSession.update(query, user);
    }
    
}
