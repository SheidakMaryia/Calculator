package by.sheidak.dao.inMemory;

import by.sheidak.dao.AddressDao;
import by.sheidak.entity.Address;
import by.sheidak.entity.Operation;
import by.sheidak.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddressDaoImpl implements AddressDao {
    private static List<Address> addresses = new ArrayList<>();

    @Override
    public void saveAddress(Address address) {
        addresses.add(new Address(addresses.size() + 1, address.getCity(), address.getStreet(), address.getNumOfHouse(), address.getUser() ));
    }

    @Override
    public List<Address> getAllByUser(User user) {
        List<Address> addressesByUser = new ArrayList<>();
        for (Address address: addresses){
            if (address.getUser().equals(user)){
                addressesByUser.add(address);
            }
        }
        return addressesByUser;
    }

    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean remove(int id, User user) {
        if(addresses.contains(user) && !addresses.contains(id)){
            Stream<Address> address = addresses.stream().filter(x -> x.getId() == id && x.getUser().equals(user));
            addresses.remove(address);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Address address) {
        if (isExist(address)) {
            Address addressForUpdate = addresses.get(addresses.indexOf(address));
            addressForUpdate.setCity(address.getCity());
            addressForUpdate.setStreet(address.getStreet());
            addressForUpdate.setNumOfHouse(address.getNumOfHouse());
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(Address address) {
        return addresses.contains(address);
    }

}
