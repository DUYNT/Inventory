/**
 * 
 */
package com.tecapro.inventory.category.dao;

import com.tecapro.inventory.category.bean.CategoryParamValue;

/**
 * Dao interface for TotalDaoImpl
 */
public interface CategoryDao {
    int addPhanKho(CategoryParamValue value);
}
