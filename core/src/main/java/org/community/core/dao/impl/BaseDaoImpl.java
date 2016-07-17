package org.community.core.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.community.core.dao.BaseDao;
import org.community.core.dao.ParameterList;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by frodo on 2014/12/23.
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    protected static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int create(T entity) {
        return 0;
    }

    @Override
    public int update(T entity) {
        return 0;
    }

    @Override
    public int update(Map<String, Object> params, Object[] ids) {
        return 0;
    }

    @Override
    public int delete(Serializable pk) {
        return 0;
    }

    @Override
    public int delete(int[] pks) {
        return 0;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public T get(int pk) {
        return null;
    }

    @Override
    public List<T> getByIds(int[] pks) {
        return null;
    }

    @Override
    public int countByParameters(ParameterList params) {
        return 0;
    }

    @Override
    public Map<String, Object> mapByParameters(int pageNo, int pageSize, ParameterList params, String orderBy) {
        return null;
    }
}
