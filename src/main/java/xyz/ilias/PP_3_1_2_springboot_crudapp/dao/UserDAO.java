package xyz.ilias.PP_3_1_2_springboot_crudapp.dao;



import xyz.ilias.PP_3_1_2_springboot_crudapp.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void edit(User user);

    User getById(int id);
}
