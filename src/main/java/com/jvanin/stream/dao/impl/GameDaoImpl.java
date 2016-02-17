package com.jvanin.stream.dao.impl;

import com.jvanin.stream.dao.GameDao;
import com.jvanin.stream.domain.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class GameDaoImpl implements GameDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Game> getAll() {
        return manager.createQuery("from Game").getResultList();
    }

    @Override
    public Long save(Game game) {
        manager.persist(game);
        return game.getId();
    }

    @Override
    public Game findById(Long id) {
        return manager.find(Game.class, id);
    }

    @Override
    public void delete(Long id) {
        Game game = this.findById(id);
        manager.remove(game);
    }
}
