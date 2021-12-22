package shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryManager {

    private SessionFactory sessionFactory;

    /**
     * Инициализируем SessionFactoryDao
     */
    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    /**
     * Возвращает саму фабрику
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Возвращает текущую сессию
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
