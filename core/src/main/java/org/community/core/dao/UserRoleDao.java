package org.community.core.dao;

import org.community.core.model.pojo.UserRole;

/**
 * Created by frodoking on 2016/11/11.
 */
public interface UserRoleDao {
    UserRole getUserRoleByRoleId(int roleId);
}
