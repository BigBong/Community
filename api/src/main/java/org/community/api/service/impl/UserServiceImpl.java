package org.community.api.service.impl;

import org.community.core.dao.UserDao;
import org.community.api.service.UserService;
import org.community.core.model.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
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
}
