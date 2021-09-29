package by.sheidak.services;

import by.sheidak.entity.Address;
import by.sheidak.entity.Operation;
import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;
import by.sheidak.services.dependencies.DependenciesService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

public class SessionFacade {
    private final Logger logger = LoggerFactory.getLogger(SessionFacade.class.getName());

    public Operation calculate(double num1, double num2, String typeOfOperation){
        return DependenciesService.calculation.getResult(num1, num2, typeOfOperation);
    }

    public void saveOperations(Operation operation){
        DependenciesService.historyOfOperations.addToHistory(operation);
    }

    public List<Operation> getHistory(User user){
        List<Operation> history = DependenciesService.historyOfOperations.showHistoryByLogin(user);
        return history;
    }

    public boolean authorization(User user){
        return DependenciesService.authorization.logIn(user);
    }

    public User getUserByLogin(User user){
        return DependenciesService.authorization.getUser(user);
    }

    public boolean registration(User user){
        return DependenciesService.registration.saveNewUser(user);
    }



    public boolean saveAddress(Address address){
        return DependenciesService.address.saveNewAddress(address);
    }

    public List<Address> getAllByUser(User user){
        return DependenciesService.address.getAllByUser(user);
    }

    public boolean removeAddress(int id, User user){
        return DependenciesService.address.remove(id, user);
    }

    public boolean update(Address address){
        return DependenciesService.address.update(address);
    }



    public boolean saveNewTelephone(Telephone telephone){
        return DependenciesService.telephone.saveNewTelephone(telephone);
    }

    public boolean removeTelephone(int id, User user){
        return DependenciesService.telephone.remove(id, user);
    }

    public List<Telephone> getAllTelephonesByUser(User user){
        return DependenciesService.telephone.getAllByUser(user);
    }

    public boolean update(Telephone telephone){
        return DependenciesService.telephone.update(telephone);
    }
}
