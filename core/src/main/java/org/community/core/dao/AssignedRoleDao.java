package org.community.core.dao;

import org.community.core.model.pojo.AssignedRole;

/**
 * Created by frodoking on 2016/11/11.
 */
public interface AssignedRoleDao {
    AssignedRole getRoleByUserId(int userId);
}
