package spring.intro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Autowired
    @Qualifier(value = "userDaoImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
