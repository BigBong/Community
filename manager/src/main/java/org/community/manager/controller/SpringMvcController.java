package org.community.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frodo on 2015/1/22.
 */
@Controller
@RequestMapping(value = "/springmvc")
public class SpringMvcController {

    @RequestMapping(value = "/welcome", method = {RequestMethod.GET})
    public ModelAndView getFirstPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("name", "My First Spring Mvc");
        return mv;
    }
}