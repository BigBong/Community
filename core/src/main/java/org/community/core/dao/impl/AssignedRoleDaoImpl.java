package org.community.core.dao.impl;

import org.community.core.dao.AssignedRoleDao;
import org.community.core.model.mapper.AssignedRoleMapper;
import org.community.core.model.pojo.AssignedRole;
import org.community.core.model.pojo.AssignedRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodoking on 2016/11/11.
 */
@Repository("assignedRoleDao")
public class AssignedRoleDaoImpl extends BaseDaoImpl<AssignedRole> implements AssignedRoleDao {

    @Autowired
    private AssignedRoleMapper assignedRoleMapper;

    @Override
    public AssignedRole getRoleByUserId(int userId) {
        AssignedRoleExample example = new AssignedRoleExample();
        AssignedRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<AssignedRole> users = assignedRoleMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}
