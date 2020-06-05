package spring.intro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
