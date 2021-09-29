package by.sheidak.dao;

import by.sheidak.entity.User;

import javax.transaction.SystemException;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getUsers();

    User getUserByLogin(User user);
}
