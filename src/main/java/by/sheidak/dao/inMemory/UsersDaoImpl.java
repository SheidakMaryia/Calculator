package by.sheidak.dao.inMemory;

import by.sheidak.dao.UserDao;
import by.sheidak.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UserDao {
    private static List<User> users = new ArrayList<>();
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByLogin(User user) {
        for (User user0: users){
            if (user0.getLogin().equals(user.getLogin())){
                return user0;
            }
        }
        return new User();
    }
}
