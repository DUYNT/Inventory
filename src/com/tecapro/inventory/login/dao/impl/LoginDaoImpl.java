/**
 * 
 */
package com.tecapro.inventory.login.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.common.model.Admin;
import com.tecapro.inventory.login.dao.LoginDao;

/**
 * Dao implement for LoginDao
 * 
 */
@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao {
    
    private String namespace = "com.tecapro.inventory.login.dao.LoginDao";

    /** Instance of SqlSession */
    @Autowired
    private SqlSession sqlSession;

    /*
     * (non-Javadoc)
     * @see com.tecapro.inventory.scr.dao.Scr0010Dao#list()
     */
    @Override
    public List<Admin> getAllUsers() {
        String query = namespace + ".getAllUsers";
        return sqlSession.selectList(query);
    }

    @Override
    public Admin getUser(Admin user) {
        String query = namespace + ".getUser";
        return sqlSession.selectOne(query, user);
    }

}
