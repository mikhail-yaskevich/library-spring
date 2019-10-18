package by.it.training.library.service;

import by.it.training.library.entity.User;

public interface UserService {
    User findUserBy(String login);
    void registration(User user);
}
