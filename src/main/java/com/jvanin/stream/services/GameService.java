package com.jvanin.stream.services;

import com.jvanin.stream.dao.GameDao;
import com.jvanin.stream.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameService {

    @Autowired
    GameDao gameDao;

    public List<Game> getAll() {
        return gameDao.getAll();
    }

    public Long save(Game game) {
        gameDao.save(game);
        return game.getId();
    }

    public Game getById(Long id) {
        return gameDao.findById(id);
    }

    public void delete(Long id) {
        gameDao.delete(id);
    }
}
