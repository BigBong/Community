package org.community.api.service.impl;

import org.community.api.common.CustomUserDetails;
import org.community.core.common.Privilege;
import org.community.core.dao.UserDao;
import org.community.api.service.UserService;
import org.community.core.model.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

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
    public List<Privilege> getPrivilegesById(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("User ------------- " + username + " --------------");
        User user = userDao.getUserByName(username);
        if (user == null || user.getArchived()) {
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }
        return new CustomUserDetails(user, getPrivilegesById(user.getId()));
    }
}
