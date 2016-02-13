package com.jvanin.stream.dao;

import com.jvanin.stream.domain.Game;

import java.util.List;

public interface GameDao {
    List<Game> getAll();
    Long save(Game game);
    Game findById(Long id);
    void delete(Long id);
}
