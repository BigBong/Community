package org.community.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by frodo on 2015/1/22.
 */
@Controller
@RequestMapping(value = "/springmvc")
public class SpringMvcController {

    @RequestMapping(value = "/welcome", method = {RequestMethod.GET})
    public String welcome(Model model) {
        model.addAttribute("name", "My First Spring Mvc");
        return "welcome";
    }

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
}
