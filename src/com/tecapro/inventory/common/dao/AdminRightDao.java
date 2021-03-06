package com.tecapro.inventory.common.dao;

import com.tecapro.inventory.common.exception.UniqueKeyException;
import com.tecapro.inventory.common.model.AdminRight;
import com.tecapro.inventory.common.model.AdminRightKey;

public interface AdminRightDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    int selectCount(AdminRight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    AdminRight selectByPK(AdminRightKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    AdminRight selectForUpdateByPK(AdminRightKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    int insert(AdminRight record) throws UniqueKeyException;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    int update(AdminRight record) throws Throwable;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    int deleteByPK(AdminRightKey key) throws Throwable;
}