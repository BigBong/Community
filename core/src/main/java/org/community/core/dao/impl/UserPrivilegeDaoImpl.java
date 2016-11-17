package org.community.core.dao.impl;

import org.community.core.dao.UserPrivilegeDao;
import org.community.core.model.mapper.UserPrivilegeMapper;
import org.community.core.model.pojo.UserPrivilege;
import org.community.core.model.pojo.UserPrivilegeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodo on 2016/11/16.
 */
@Repository("userPrivilegeDao")
public class UserPrivilegeDaoImpl extends BaseDaoImpl<UserPrivilege> implements UserPrivilegeDao {

    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    @Override
    public List<UserPrivilege> getUserPrivileges(int userId) {
        UserPrivilegeExample example = new UserPrivilegeExample();
        UserPrivilegeExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userPrivilegeMapper.selectByExample(example);
    }
}
