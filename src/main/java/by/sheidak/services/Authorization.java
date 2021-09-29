package by.sheidak.services;

import by.sheidak.dao.UserDao;
import by.sheidak.entity.User;

public class Authorization {
    private UserDao usersDao;

    public Authorization(UserDao usersDao) {
        this.usersDao = usersDao;
    }

    public Authorization() {}

    public UserDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UserDao usersDao) {
        this.usersDao = usersDao;
    }

    public boolean logIn(User user){
        if (usersDao.getUsers().contains(user)){
            //usersDao.getUserByLogin(user.getLogin());
            return true;
        }else{
            return false;
        }
    }

    public User getUser(User user){
        User userByLogin = usersDao.getUserByLogin(user);
        return userByLogin;
    }

}
