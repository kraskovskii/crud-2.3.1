package service;

import dao.UserDaoImp;
import model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    @Transactional
    public List<User> getAllUsers();
    @Transactional
    public void addUser(User user);
    @Transactional
    public void updateUser(User user);
    @Transactional
    public User getUserById(Long id);
    @Transactional
    public void deleteUser(User user);
    @Transactional
    public void deleteUserById(long id);
}
