package by.it.training.library.service.impl;

import by.it.training.library.dao.UserDao;
import by.it.training.library.entity.User;
import by.it.training.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registration(User user) {
        userDao.registration(user);
    }

    @Override
    public User findUserBy(String login) {
        return userDao.findUserBy(login);
    }
}
