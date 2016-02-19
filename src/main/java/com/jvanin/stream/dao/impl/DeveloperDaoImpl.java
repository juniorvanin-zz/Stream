package com.jvanin.stream.dao.impl;

import com.jvanin.stream.dao.DeveloperDao;
import com.jvanin.stream.domain.Developer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DeveloperDaoImpl implements DeveloperDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Developer> getAll() {
        return entityManager.createQuery("from Developer").getResultList();
    }

    @Override
    public Developer getById(Long developerId) {
        return entityManager.find(Developer.class, developerId);
    }
}
