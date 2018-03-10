package DataAccessObject;

import Entity.Bottoms;
import Entity.Toppings;
import Entity.User;
import MyDataSource.CupcakeDataSource;
import java.util.List;


public class Handler {
    
    private DAOCupcake dao = new DAOCupcake(new CupcakeDataSource().getDataSource());
    
    public User loginAuthentication(String email, String password){
        return dao.loginAuthentication(email, password);
    }
    
    public boolean checkIfRegisterable(String email, String password){
        return dao.checkIfRegisterable(email, password);
    }
    
    public boolean createUser(String email, String password, int credit){
        return dao.createUser(email, password, credit);
    }
    
    public List<Bottoms> getAllBottoms(){
        return dao.getAllBottoms();
    }
    
    public List<Toppings> getAllToppings(){
        return dao.getAllToppings();
    }
    
    public List<User> getUsers(){
        return dao.getUsers();
    }
    
    public void deleteUser(int userID){
        dao.deleteUser(userID);
    }
    
    public int bottomPrice(String name){
        return dao.bottomPrice(name);
    }
}
