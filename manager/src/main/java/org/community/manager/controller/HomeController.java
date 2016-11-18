package org.community.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by frodo on 2016/11/9.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Welcome Spring Mvc");
        return "welcome";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }
}
