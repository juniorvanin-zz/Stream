package com.jvanin.stream.services;

import com.jvanin.stream.dao.MovieDao;
import com.jvanin.stream.domain.Movie;
import com.jvanin.stream.exceptions.CouldNotSaveResourceException;
import com.jvanin.stream.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    public List<Movie> getAll() {
        List<Movie> movies = movieDao.getAll();

        if (movies == null){
            throw new ResourceNotFoundException("Movie");
        }

        return movies;
    }

    public Long save(Movie movie) {
        movieDao.save(movie);

        if (movie.getId() == null) {
            throw new CouldNotSaveResourceException();
        }
        return movie.getId();
    }

    public Movie getById(Long id) {
        Movie movie = movieDao.findById(id);

        if (movie == null){
            throw new ResourceNotFoundException("Movie", id);
        }

        return movie;
    }

    public void delete(Long id) {
        movieDao.delete(id);
    }
}
