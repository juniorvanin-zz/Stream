package com.jvanin.stream.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Log4j
@RestController
public class HeathCheckController {

    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public String get(){

        log.info("HealthCheck works properly.");

        return "OK";
    }
}

