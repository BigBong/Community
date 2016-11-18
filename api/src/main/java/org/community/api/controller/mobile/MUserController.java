package org.community.api.controller.mobile;

import org.apache.log4j.Logger;
import org.community.core.service.UserService;
import org.community.core.common.ReturnMsg;
import org.community.core.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("m/user")
public class MUserController {
    private static final Logger logger = Logger.getLogger(MUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{username}")
    @ResponseBody
    public ReturnMsg getUser(@PathVariable("username") String username) {
        logger.info("getByIdFromParam >> username:" + username);
        User user = userService.getUserByName(username);
        return ReturnMsg.success("success", user);
    }

    @RequestMapping(value = "list")
    @ResponseBody
    public ReturnMsg getUsers() {
        logger.info("getPersons");
        List<User> users = userService.getList();
        return ReturnMsg.success("success",users);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg insert(@RequestBody User user) {
        int flag = userService.save(user);
        if (flag == 0) {
            return ReturnMsg.success("insert user success.");
        } else {
            return ReturnMsg.fail(ReturnMsg.CODE_INTERNAL_ERROR, "insert user fail.");
        }
    }
}
