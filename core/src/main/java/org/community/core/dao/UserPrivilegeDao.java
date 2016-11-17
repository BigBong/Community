package org.community.core.dao;

import org.community.core.model.pojo.UserPrivilege;

import java.util.List;

/**
 * Created by frodo on 2016/11/16.
 */
public interface UserPrivilegeDao {
    List<UserPrivilege> getUserPrivileges(int userId);
}
