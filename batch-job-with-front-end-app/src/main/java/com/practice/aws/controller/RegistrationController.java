package com.practice.aws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView renderRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam String userName, @RequestParam String email, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        //TODO do registration
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
