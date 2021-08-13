package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

}
