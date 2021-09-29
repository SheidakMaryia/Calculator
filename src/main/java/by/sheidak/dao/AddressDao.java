package by.sheidak.dao;

import by.sheidak.entity.Address;
import by.sheidak.entity.User;

import java.util.List;

public interface AddressDao {

    void saveAddress(Address address);

    List<Address> getAllByUser(User user);

    List<Address> getAddresses();

    boolean remove(int id, User user);

    boolean update(Address address);

    boolean isExist(Address address);
}
