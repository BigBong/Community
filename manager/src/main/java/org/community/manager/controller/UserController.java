package org.community.manager.controller;

import org.community.core.dao.UserDao;
import org.community.core.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by frodo on 2016/11/9.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "list")
    @ResponseBody
    public List<User> list() {
        return userDao.getUsers();
    }
}
