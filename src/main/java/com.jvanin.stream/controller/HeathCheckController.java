package com.jvanin.stream.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HeathCheckController {

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public String get(){
        Logger logger = Logger.getLogger(HeathCheckController.class);
        logger.info("HealthCheck works properly.");

        return "OK";
    }
}

