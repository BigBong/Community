package org.community.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * Created by frodo on 2014/12/23.
 */
public interface BaseDao<T> {
    public int create(T entity);
    public int update(T entity);
    public int update(Map<String, Object> params, Object[] ids);
    public int delete(Serializable pk);
    public int delete(int[] pks);
    public void deleteAll();
    public T get(int pk);
    public List<T> getByIds(int[] pks);
    public int countByParameters(ParameterList params);
    public Map<String,Object> mapByParameters(int pageNo, int pageSize, ParameterList params, String orderBy);
}
