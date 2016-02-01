package com.jvanin.stream.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Log4j
@Controller
public class HeathCheckController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get(){

        log.info("HealthCheck works properly.");

        return new ModelAndView("index");
    }
}

