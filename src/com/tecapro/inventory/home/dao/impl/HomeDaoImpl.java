/**
 * 
 */
package com.tecapro.inventory.home.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.home.dao.HomeDao;

/**
 * Dao implement for HomeDao
 * 
 */
@Repository("HomeDao")
public class HomeDaoImpl implements HomeDao {
    
    private String namespace = "com.tecapro.inventory.home.dao.HomeDao";

    /** Instance of SqlSession */
    @Autowired
    private SqlSession sqlSession;

}
