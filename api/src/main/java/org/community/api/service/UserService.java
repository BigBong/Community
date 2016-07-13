package org.community.api.service;


import org.community.core.model.pojo.User;

import java.util.List;

public interface UserService {
    User getById(int id);

    User getUserByName(String username);

    int save(User user);

    List<User> getList();
}
