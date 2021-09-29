package by.sheidak.services;

import by.sheidak.dao.AddressDao;
import by.sheidak.entity.Address;
import by.sheidak.entity.User;

import java.util.List;

public class AddressService {
    private AddressDao addressDao;

    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public AddressService() {}

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public boolean saveNewAddress(Address address){
        if (!addressDao.getAddresses().contains(address)){
            addressDao.saveAddress(address);
            return true;
        }
        return false;
    }

    public List<Address> getAllByUser(User user){
        return addressDao.getAllByUser(user);
    }

    public boolean remove(int id, User user){
        if (addressDao.getAllByUser(user).size() != 1){
            if (addressDao.getAddresses().contains(id)){
                return addressDao.remove(id, user);
            }
        }
        return false;
    }

    public boolean update(Address address){
        return addressDao.update(address);
    }



}
