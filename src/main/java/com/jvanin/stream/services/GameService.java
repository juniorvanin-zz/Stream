package com.jvanin.stream.services;

import com.jvanin.stream.dao.GameDao;
import com.jvanin.stream.domain.Game;
import com.jvanin.stream.exceptions.CouldNotSaveResourceException;
import com.jvanin.stream.exceptions.ResourceNotFoundException;
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
        List<Game> games = gameDao.getAll();

        if (games == null){
            throw new ResourceNotFoundException("Game");
        }

        return games;
    }

    public Long save(Game game) {
        gameDao.save(game);

        if (game.getId() == null) {
            throw new CouldNotSaveResourceException();
        }
        return game.getId();
    }

    public Game getById(Long id) {
        Game game = gameDao.findById(id);

        if (game == null){
            throw new ResourceNotFoundException("Game", id);
        }

        return game;
    }

    public void delete(Long id) {
        gameDao.delete(id);
    }
}
