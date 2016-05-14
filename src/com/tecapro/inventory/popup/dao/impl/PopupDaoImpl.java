/**
 * 
 */
package com.tecapro.inventory.popup.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.popup.dao.PopupDao;

/**
 * Dao implement for HomeDao
 * 
 */
@Repository("PopupDao")
public class PopupDaoImpl implements PopupDao {
    
    private String namespace = "com.tecapro.inventory.popup.dao.PopupDao";

    /** Instance of SqlSession */
    @Autowired
    private SqlSession sqlSession;

}
