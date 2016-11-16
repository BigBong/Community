package org.community.api.service.impl;

import org.community.api.common.OauthUserDetails;
import org.community.core.dao.AssignedRoleDao;
import org.community.core.dao.UserDao;
import org.community.api.service.UserService;
import org.community.core.dao.UserRoleDao;
import org.community.core.model.pojo.AssignedRole;
import org.community.core.model.pojo.User;
import org.community.core.model.pojo.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private AssignedRoleDao assignedRoleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User getById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getList() {
        return userDao.getUsers();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("User ------------- " + username + " --------------");
        User user = userDao.getUserByName(username);
        if (user == null || user.getArchived()) {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }

        AssignedRole assignedRole = assignedRoleDao.getRoleByUserId(user.getId());
        UserRole userRole = null;
        if (assignedRole != null) {
            userRole = userRoleDao.getUserRoleByRoleId(assignedRole.getRoleId());
        }

        return new OauthUserDetails(user, userRole == null ? "" : userRole.getRoleName());
    }
}
