package org.community.api.controller.web;

import org.community.api.service.UserService;
import org.community.core.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Shengzhao Li
 */
@Controller
@RequestMapping("web/user")
public class WUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("dashboard")
    public String dashboard() {
        return "web/dashboard";
    }

    @RequestMapping("users")
    @ResponseBody
    public List<User> users() {
        return userService.getList();
    }
}