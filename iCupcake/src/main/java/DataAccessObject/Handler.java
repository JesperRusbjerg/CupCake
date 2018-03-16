package DataAccessObject;

import Entity.Bottoms;
import Entity.CupCake;
import Entity.Order;
import Entity.Toppings;
import Entity.User;
import MyDataSource.CupcakeDataSource;
import java.util.List;

/**
 * This is the class representing the storage facade.
 * It acts as an intermediary between the servlets and the DataAccessObject, which
 * is described here {@link  DAOCupcake}
 * @author mette
 */
public class Handler {
    
    private DAOCupcake dao = new DAOCupcake(new CupcakeDataSource().getDataSource());
    
    
    /**
     * is described in DAO: {@link  DAOCupcake#loginAuthentication(java.lang.String, java.lang.String)}
     * @param email
     * @param password
     * @return 
     */
    public User loginAuthentication(String email, String password){
        return dao.loginAuthentication(email, password);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#checkIfRegisterable(java.lang.String, java.lang.String) }
     * @param email
     * @param password
     * @return 
     */
    public boolean checkIfRegisterable(String email, String password){
        return dao.checkIfRegisterable(email, password);
    }
    
    
    /**
     * is described in DAO: {@link  DAOCupcake#createUser(java.lang.String, java.lang.String, java.lang.String, int) }
     * @param username
     * @param email
     * @param password
     * @param credit
     * @return 
     */
    public boolean createUser(String username, String email, String password, int credit){
        return dao.createUser(username, email, password, credit);
    }
    
    /**
     * is described in DAO: {@link DAOCupcake#getAllBottoms() }
     * @return 
     */
    public List<Bottoms> getAllBottoms(){
        return dao.getAllBottoms();
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#getAllToppings() }
     * @return 
     */
    public List<Toppings> getAllToppings(){
        return dao.getAllToppings();
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#getUsers() }
     * @return 
     */
    public List<User> getUsers(){
        return dao.getUsers();
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#deleteUser(int) }
     * @param userID 
     */
    public void deleteUser(int userID){
        dao.deleteUser(userID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#findBottom(int) }
     * @param bottomsID
     * @return 
     */
    public Bottoms findBottom(int bottomsID){
        return dao.findBottom(bottomsID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#findTopping(int) }
     * @param toppingsID
     * @return 
     */
    public Toppings findTopping(int toppingsID){
        return dao.findTopping(toppingsID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#setCreditToUser(Entity.User, int) }
     * @param user
     * @param credit 
     */
    public void setCreditToUser(User user, int credit){
        dao.setCreditToUser(user, credit);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#addOrder(int, int) }
     * @param price
     * @param userID 
     */
    public void addOrder(int price, int userID){
        dao.addOrder(price, userID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#getOrderID(int) }
     * @param userID
     * @return 
     */
    public int getOrderID(int userID){
        return dao.getOrderID(userID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#addOrderItem(int, int, int, int, int) }
     * @param orderID
     * @param toppingsID
     * @param bottomsID
     * @param cupcakePrice
     * @param quantity 
     */
    public void addOrderItem(int orderID, int toppingsID, int bottomsID, int cupcakePrice, int quantity){
        dao.addOrderItem(orderID, toppingsID, bottomsID, cupcakePrice, quantity);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#showOrdersForUser(int) }
     * @param userID
     * @return 
     */
    public List<Order> showOrdersForUser(int userID){
        return dao.showOrdersForUser(userID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#OrderDetailsUser(int) }
     * @param orderID
     * @return 
     */
    public List<CupCake> OrderDetailsUser(int orderID){
        return dao.OrderDetailsUser(orderID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#AllOrders() }
     * @return 
     */
    public List<Order> AllOrders(){
        return dao.AllOrders();
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#updateTotalPrice(int, int) }
     * @param price
     * @param orderID 
     */
    public void updateTotalPrice(int price, int orderID){
        dao.updateTotalPrice(price, orderID);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#addBottom(java.lang.String, int) }
     * @param name
     * @param price 
     */
    public void addBottom(String name, int price){
        dao.addBottom(name, price);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#addTopping(java.lang.String, int) }
     * @param name
     * @param price 
     */
    public void addTopping(String name, int price){
        dao.addTopping(name, price);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#getUser(java.lang.String) }
     * @param emailaddress
     * @return 
     */
    public User getUser(String emailaddress){
        return dao.getUser(emailaddress);
    }
    
    /**
     * is described in DAO: {@link  DAOCupcake#getUser(int) }
     * @param userID
     * @return 
     */
     public User getUser(int userID){
        return dao.getUser(userID);
     }
}
