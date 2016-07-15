package org.community.api.controller.mobile;

import org.community.api.service.UserService;
import org.community.core.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/m/")
public class MobileController {

    @Autowired
    private UserService userService;

    @RequestMapping("users")
    @ResponseBody
    public List<User> users() {
        return userService.getList();
    }

}