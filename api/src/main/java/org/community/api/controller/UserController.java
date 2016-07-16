package org.community.api.controller;

import org.apache.log4j.Logger;
import org.community.api.service.UserService;
import org.community.core.common.ReturnMsg;
import org.community.core.model.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("m/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "{username}")
    @ResponseBody
    public ReturnMsg<User> getUser(@PathVariable("username") String username) {
        logger.info("getByIdFromParam >> username:" + username);
        User user = userService.getUserByName(username);
        if (user != null) {
            return ReturnMsg.success(user);
        } else {
            return ReturnMsg.fail();
        }
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public ReturnMsg<List<User>> getUsers() {
        logger.info("getPersons");
        List<User> users = userService.getList();
        if (users != null) {
            return ReturnMsg.success(users);
        } else {
            return ReturnMsg.fail();
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg insert(@RequestBody User user) {
        int flag = userService.save(user);
        if (flag == 0) {
            return ReturnMsg.success("insert user success.");
        } else {
            return ReturnMsg.error("insert user fail.");
        }
    }
}
