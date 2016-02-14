package com.jvanin.stream.utils;

import com.jvanin.stream.domain.Game;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                configuration.configure("hibernate-configuration.xml");

                configuration.addAnnotatedClass(Game.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Annotation serviceRegistry created");

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return sessionFactory;
    }
}
