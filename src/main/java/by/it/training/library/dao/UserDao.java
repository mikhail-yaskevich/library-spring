package by.it.training.library.dao;

import by.it.training.library.entity.User;

public interface UserDao {
    User findUserBy(String login);
    void registration(User user);
}
