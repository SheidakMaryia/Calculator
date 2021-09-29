package by.sheidak.services;

import by.sheidak.dao.UserDao;
import by.sheidak.entity.User;

public class Registration {
    private UserDao usersDao;

    public Registration(UserDao usersDao) {
        this.usersDao = usersDao;
    }

    public Registration() {}

    public UserDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UserDao usersDao) {
        this.usersDao = usersDao;
    }

    public boolean saveNewUser (User user){
        if (!usersDao.getUsers().contains(user)){
            usersDao.addUser(user);
            return true;
        }else {
            return false;
        }
    }
}
