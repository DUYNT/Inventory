package com.tecapro.inventory.common.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecapro.inventory.common.dao.AdminRightDao;
import com.tecapro.inventory.common.exception.UniqueKeyException;
import com.tecapro.inventory.common.model.AdminRight;
import com.tecapro.inventory.common.model.AdminRightKey;

@Repository("AdminRightDao")
public class AdminRightDaoImpl implements AdminRightDao {
    private String namespace = "com.tecapro.inventory.common.dao.AdminRightDao";

    @Autowired
    private SqlSession sqlSession;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public int selectCount(AdminRight record) {
        String query = namespace + ".selectCount";
        return sqlSession.selectOne(query, record);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public AdminRight selectByPK(AdminRightKey key) {
        String query = namespace + ".selectByPK";
        return sqlSession.selectOne(query, key);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public AdminRight selectForUpdateByPK(AdminRightKey key) {
        String query = namespace + ".selectForUpdateByPK";
        return sqlSession.selectOne(query, key);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public int insert(AdminRight record) throws UniqueKeyException {
        String query = namespace + ".insert";
        return sqlSession.insert(query, record);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public int update(AdminRight record) throws Throwable {
        String query = namespace + ".update";
        return sqlSession.update(query, record);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin_right
     *
     * @author MbGenerated
     */
    @Override
    public int deleteByPK(AdminRightKey key) throws Throwable {
        String query = namespace + ".deleteByPK";
        return sqlSession.delete(query, key);
    }
}