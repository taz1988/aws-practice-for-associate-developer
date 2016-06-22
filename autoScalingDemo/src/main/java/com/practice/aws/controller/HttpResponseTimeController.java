package com.practice.aws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpResponseTimeController {

    @RequestMapping(value = "waitBeforeResponse", method = RequestMethod.GET)
    @ResponseBody
    public String waitBeforeResponse(@RequestParam(name = "time") int time) throws InterruptedException {
        Thread.sleep(time);
        return "ok";
    }

}
