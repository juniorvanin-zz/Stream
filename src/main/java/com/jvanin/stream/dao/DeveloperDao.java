package com.jvanin.stream.dao;

import com.jvanin.stream.domain.Developer;

import java.util.List;

public interface DeveloperDao {
    List<Developer> getAll();
    Developer getById(Long developerId);
}
