/**
 * 
 */
package com.tecapro.inventory.category.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.category.bean.CategoryParamValue;
import com.tecapro.inventory.category.dao.CategoryDao;
import com.tecapro.inventory.category.logic.CategoryLogic;

/**
 * Dao implement for TotalLogic
 * 
 */
@Repository("CategoryLogic")
public class CategoryLogicImpl implements CategoryLogic {
    
    @Autowired
    private CategoryDao dao;

    @Override
    public int addPhanKho(CategoryParamValue value) {
        return dao.addPhanKho(value);
    }
    
}
