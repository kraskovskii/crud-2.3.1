package dao;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }

    public void addUser(User user){
        entityManager.persist(user);
    }

    public void updateUser(User user){
        entityManager.merge(user);
    }

    public User getUserById(Long id){
        return entityManager.find(User.class, id);
    }

    public void deleteUser(User user){
        entityManager.remove(entityManager.contains(user)? user: entityManager.merge(user));
    }
}
