package by.sheidak.dao.inMemory;

import by.sheidak.dao.TelephoneDao;
import by.sheidak.entity.Address;
import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TelephoneDaoImpl implements TelephoneDao {
    private static List<Telephone> telephones = new ArrayList<>();

    @Override
    public void saveTelephone(Telephone telephone) {
        telephones.add(new Telephone(telephones.size() + 1,telephone.getNumber(), telephone.getUser() ));
    }

    @Override
    public List<Telephone> getAllByUser(User user) {
        List<Telephone> telephonesByUser = new ArrayList<>();
        for (Telephone telephone: telephones){
            if (telephone.getUser().equals(user)){
                telephonesByUser.add(telephone);
            }
        }
        return telephonesByUser;
    }

    @Override
    public boolean remove(int id, User user) {
        if(telephones.contains(user) && !telephones.contains(id)){
            Stream<Telephone> telephone = telephones.stream().filter(x -> x.getId() == id && x.getUser().equals(user));
            telephones.remove(telephone);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Telephone telephone) {
        if (isExist(telephone)) {
            Telephone newTelephone = telephones.get(telephones.indexOf(telephone));
            newTelephone.setNumber(telephone.getNumber());
            return true;
        }
        return false;
    }

    @Override
    public boolean isExist(Telephone telephone) {
        return telephones.contains(telephone);
    }
}
