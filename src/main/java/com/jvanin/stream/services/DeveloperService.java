package com.jvanin.stream.services;

import com.jvanin.stream.dao.DeveloperDao;
import com.jvanin.stream.domain.Developer;
import com.jvanin.stream.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    DeveloperDao developerDao;

    public List<Developer> getAll() {
        List<Developer> developers = developerDao.getAll();

        if (developers == null) {
            throw new ResourceNotFoundException("Developer");
        }

        return developers;
    }

    public Developer findById(Long id) {
        Developer developer = developerDao.getById(id);

        if (developer == null) {
            throw new ResourceNotFoundException("Developer", id);
        }

        return developer;
    }


}
