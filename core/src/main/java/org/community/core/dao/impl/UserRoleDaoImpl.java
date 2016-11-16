package org.community.core.dao.impl;

import org.community.core.dao.UserRoleDao;
import org.community.core.model.mapper.UserRoleMapper;
import org.community.core.model.pojo.UserRole;
import org.community.core.model.pojo.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodoking on 2016/11/11.
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRole getUserRoleByRoleId(int roleId) {
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);

        List<UserRole> users = userRoleMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}
