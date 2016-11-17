package org.community.core.service;


import org.community.core.model.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getById(int id);

    User getUserByName(String username);

    int save(User user);

    List<User> getList();
}
