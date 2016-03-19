package com.jvanin.stream.dao;

import com.jvanin.stream.domain.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
    Long save(Movie movie);
    Movie findById(Long id);
    void delete(Long id);
}
