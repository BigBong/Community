package org.community.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Created by frodo on 2014/12/23.
 */
public interface BaseDao<T> {
    int create(T entity);

    int update(T entity);

    int update(Map<String, Object> params, Object[] ids);

    int delete(Serializable pk);

    int delete(int[] pks);

    void deleteAll();

    T get(int pk);

    List<T> getByIds(int[] pks);

    int countByParameters(ParameterList params);

    Map<String, Object> mapByParameters(int pageNo, int pageSize, ParameterList params, String orderBy);
}
