package com.jvanin.stream.dao.impl;

import com.jvanin.stream.dao.GameDao;
import com.jvanin.stream.domain.Game;
import com.jvanin.stream.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GameDaoImpl implements GameDao {
    @Override
    public List<Game> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Game> games = (List<Game>) session.createQuery("from Game").list();
        transaction.commit();
        return games;
    }

    @Override
    public Long save(Game game) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(game);
        transaction.commit();

        return game.getId();
    }

    @Override
    public Game findById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Game game = session.get(Game.class, id);

        return game;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Game game = this.findById(id);
        session.delete(game);
        transaction.commit();
    }
}
