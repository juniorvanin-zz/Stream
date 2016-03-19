package com.jvanin.stream.rest;

import com.jvanin.stream.domain.Movie;
import com.jvanin.stream.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @RequestMapping(value = "/{movieId}")
    public Movie getById(@PathVariable Long movieId) {
        return movieService.getById(movieId);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long movieId){
        movieService.delete(movieId);
    }

}
