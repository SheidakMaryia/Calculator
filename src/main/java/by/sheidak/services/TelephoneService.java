package by.sheidak.services;

import by.sheidak.dao.TelephoneDao;
import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;

import java.util.List;

public class TelephoneService {
    private TelephoneDao telephoneDao;

    public TelephoneService(TelephoneDao telephoneDao) {
        this.telephoneDao = telephoneDao;
    }

    public TelephoneService() {}

    public TelephoneDao getTelephoneDao() {
        return telephoneDao;
    }

    public void setTelephoneDao(TelephoneDao telephoneDao) {
        this.telephoneDao = telephoneDao;
    }

    public boolean saveNewTelephone(Telephone telephone){
        if (!telephoneDao.isExist(telephone)){
            telephoneDao.saveTelephone(telephone);
            return true;
        }
        return false;
    }

    public List<Telephone> getAllByUser(User user){
       return telephoneDao.getAllByUser(user);
    }

    public boolean remove(int id, User user){
        if (telephoneDao.getAllByUser(user).size() != 1){
            return telephoneDao.remove(id, user);
        }
        return false;
    }

    public boolean update(Telephone telephone){
        return telephoneDao.update(telephone);
    }
}
