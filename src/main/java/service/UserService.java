package service;

import model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public User getUserById(Long id);

    public void deleteUser(User user);

    public void deleteUserById(long id);
}
