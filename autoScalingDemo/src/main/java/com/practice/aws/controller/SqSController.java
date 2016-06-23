package com.practice.aws.controller;


import com.practice.aws.sqs.SqSProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Profile("producer")
public class SqSController {

    @Autowired
    private SqSProcessor sqsProcessor;

    @ResponseBody
    @RequestMapping(value = "/sendSqsMessages", method = RequestMethod.GET)
    public String sendMessagesToSqS(@RequestParam("messageNumber") int messageNumber) {
        sqsProcessor.sendTestMessages(messageNumber);
        return "ok";
    }
}
