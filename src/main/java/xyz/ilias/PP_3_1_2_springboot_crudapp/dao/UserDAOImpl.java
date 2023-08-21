package xyz.ilias.PP_3_1_2_springboot_crudapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import xyz.ilias.PP_3_1_2_springboot_crudapp.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        Query query = entityManager.createNativeQuery("select * from Users", User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager
                .createQuery("DELETE FROM User WHERE id =:userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
