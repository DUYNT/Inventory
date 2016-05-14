/**
 * 
 */
package com.tecapro.inventory.category.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.category.bean.CategoryParamValue;
import com.tecapro.inventory.category.dao.CategoryDao;

/**
 * Dao implement for TotalLogic
 * 
 */
@Repository("CategoryDao")
public class CategoryDaoImpl implements CategoryDao {
    
    String namespase = "com.tecapro.inventory.category.dao.CategoryDao";
    
    @Autowired
    private SqlSession session;
    
    @Override
    public int addPhanKho(CategoryParamValue value) {
        String query = namespase + ".addPhanKho";
        return session.insert(query, value);
    }
    
}
