package by.it.training.library.dao.impl;

import by.it.training.library.dao.UserDao;
import by.it.training.library.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public User findUserBy(String login) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where login = :login", User.class);
            query.setParameter("login", login);
            if (query.getResultList().size() > 0) {
                return query.getSingleResult();
            } else {
                return null;
            }
        }
    }

    ////@Transactional
    @Override
    public void registration(User user) {
        System.out.println("dao.registration");
        sessionFactory.openSession().save(user);
        System.out.println("dao.registration: yes");
    }
}
