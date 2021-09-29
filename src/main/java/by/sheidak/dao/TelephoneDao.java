package by.sheidak.dao;

import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;

import java.util.List;

public interface TelephoneDao {
    void saveTelephone(Telephone telephone);

    List<Telephone> getAllByUser(User user);

    boolean remove(int id, User user);

    boolean update(Telephone telephone);

    boolean isExist(Telephone telephone);
}
