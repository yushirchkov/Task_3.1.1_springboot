package springboot.service;


import springboot.model.User;

import java.util.List;

public interface UserService {

    void delete(long id);

    void update(long id, User user);

    Object getUserById(long id);

    void add(User user);

    List<User> listUsers();
}
