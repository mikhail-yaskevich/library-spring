package by.it.training.library.service.impl;

import by.it.training.library.dao.UserDao;
import by.it.training.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findUserBy(login);
        UserBuilder builder;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(user.getLogin());
            //builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            //String[] authorities = user.getAuthorities()
            //        .stream().map(a -> a.getAuthority()).toArray(String[]::new);
            //SimpleGrantedAuthority
            builder.roles(user.getRole().getRoleType().name());
            //builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
