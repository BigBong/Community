package org.community.core.dao;

import org.community.core.model.pojo.User;

import java.util.List;

/**
 * Created by frodoking on 2014/12/23.
 */
public interface UserDao {
    User getUserById(int id);

    User getUserByName(String username);

    List<User> getUsers();

    int save(User user);
}
