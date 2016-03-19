package com.jvanin.stream.dao.impl;

import com.jvanin.stream.dao.MovieDao;
import com.jvanin.stream.domain.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Movie> getAll() {
        return manager.createQuery("from Movie").getResultList();
    }

    @Override
    public Long save(Movie movie) {
        manager.persist(movie);
        return movie.getId();
    }

    @Override
    public Movie findById(Long id) {
        return manager.find(Movie.class, id);
    }

    @Override
    public void delete(Long id) {
        Movie movie = this.findById(id);
        manager.remove(movie);
    }
}
