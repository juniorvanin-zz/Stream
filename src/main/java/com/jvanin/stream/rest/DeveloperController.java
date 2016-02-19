package com.jvanin.stream.rest;

import com.jvanin.stream.domain.Developer;
import com.jvanin.stream.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService){
        this.developerService = developerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> getAll(){
        return developerService.getAll();
    }

    @RequestMapping(value = "/{developerId}", method = RequestMethod.GET)
    public Developer getById(@PathVariable Long developerId){
        return developerService.findById(developerId);
    }

}
