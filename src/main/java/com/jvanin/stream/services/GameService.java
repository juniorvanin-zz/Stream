package com.jvanin.stream.services;

import com.jvanin.stream.domain.Game;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameService  {

    public List<Game> getAll() {
//        Iterable<Game> gameIterable = gameDao.findAll();
        List<Game> games = new ArrayList<>();
        games.add(new Game(1L, "Metal Gear", 2015));
        games.add(new Game(2L, "Destiny", 2015));
        return games;
    }
}
