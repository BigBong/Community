package org.community.core.dao.impl;

import org.community.core.dao.UserDao;
import org.community.core.model.mapper.UserMapper;
import org.community.core.model.pojo.User;
import org.community.core.model.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodoking on 2014/12/23.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getUserByName(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public int save(User person) {
        return userMapper.insertSelective(person);
    }
}
