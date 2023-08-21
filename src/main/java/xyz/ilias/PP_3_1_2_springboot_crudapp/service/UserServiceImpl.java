package xyz.ilias.PP_3_1_2_springboot_crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.ilias.PP_3_1_2_springboot_crudapp.dao.UserDAO;
import xyz.ilias.PP_3_1_2_springboot_crudapp.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
