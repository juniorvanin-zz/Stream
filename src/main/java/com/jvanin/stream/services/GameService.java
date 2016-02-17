package com.jvanin.stream.services;

import com.jvanin.stream.dao.GameDao;
import com.jvanin.stream.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    GameDao gameDao;

    @Autowired
    public GameService(GameDao gameDao){
        this.gameDao = gameDao;
    }

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
