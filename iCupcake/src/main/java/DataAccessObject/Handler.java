package DataAccessObject;

import Entity.Bottoms;
import Entity.CupCake;
import Entity.Order;
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
    
    public boolean createUser(String username, String email, String password, int credit){
        return dao.createUser(username, email, password, credit);
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
    
    public Bottoms findBottom(int bottomsID){
        return dao.findBottom(bottomsID);
    }
    
    public Toppings findTopping(int toppingsID){
        return dao.findTopping(toppingsID);
    }
    
    public void setCreditToUser(User user, int credit){
        dao.setCreditToUser(user, credit);
    }
    
    public void addOrder(int price, int userID){
        dao.addOrder(price, userID);
    }
    
    public int getOrderID(int userID){
        return dao.getOrderID(userID);
    }
    
    public void addOrderItem(int orderID, int toppingsID, int bottomsID, int cupcakePrice, int quantity){
        dao.addOrderItem(orderID, toppingsID, bottomsID, cupcakePrice, quantity);
    }
    
    public List<Order> showOrdersForUser(int userID){
        return dao.showOrdersForUser(userID);
    }
    
    public List<CupCake> OrderDetailsUser(int orderID){
        return dao.OrderDetailsUser(orderID);
    }
    
    public List<Order> AllOrders(){
        return dao.AllOrders();
    }
    
    public void updateTotalPrice(int price, int orderID){
        dao.updateTotalPrice(price, orderID);
    }
    
    public void addBottom(String name, int price){
        dao.addBottom(name, price);
    }
    
    public void addTopping(String name, int price){
        dao.addTopping(name, price);
    }
    
    public User getUser(String emailaddress){
        return dao.getUser(emailaddress);
    
       
    }
     public User getUser(int userID){
        return dao.getUser(userID);
     }
}
