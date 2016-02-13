package com.jvanin.stream.dao;

import com.jvanin.stream.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDao extends CrudRepository<Game, Long> {}
