package xyz.ilias.PP_3_1_2_springboot_crudapp.service;



import xyz.ilias.PP_3_1_2_springboot_crudapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void edit(User user);
    void delete(int id);
    User getById(int id);
}
