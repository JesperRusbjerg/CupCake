package DataAccessObject;

import javax.sql.DataSource;
import DBConnector.DBConnector;
import Entity.Bottoms;
import Entity.CupCake;
import Entity.Order;
import Entity.Toppings;
import Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCupcake {

    private DBConnector dbc = new DBConnector();

    public DAOCupcake(DataSource ds) {
        dbc.setDataSource(ds);
    }

    /**
     * Authenticates users email and password input.
     *
     * @param email not null
     * @param password not null
     * @return User object to be used in session.
     */
    public User loginAuthentication(String email, String password) {

        User res = null;
        try {
            dbc.open();

            String sql = "select * from users where u_email=? and u_password=?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, email);
            s.setString(2, password);
            ResultSet resultset = s.executeQuery();
            resultset.next();
            String u_email = resultset.getString("u_email");
            String u_psw = resultset.getString("u_password");
            if (email.equals(u_email) && password.equals(u_psw)) {
                String u_username = resultset.getString("u_username");
                int userID = resultset.getInt("userID");
                int credit = resultset.getInt("u_credit");
                boolean admin = resultset.getBoolean("admin");
                res = new User(u_username, u_email, u_psw, credit, admin, userID);
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    /**
     * Checks users input (email, password). Checks that neither input is an
     * empty string, and that email does not exist already in the database.
     *
     * @param email not null
     * @param password not null
     * @return true if registerable
     */
    public boolean checkIfRegisterable(String email, String password) {
        try {
            dbc.open();
            if (email.equals("") || password.equals("")) {
                return false;
            }
            String sql = " select * from users where u_email=?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, email);
            ResultSet resultset = s.executeQuery();
            resultset.next();
            String u_email = resultset.getString("u_email");
            if (email.equals(u_email)) {
                return false;
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    /**
     * Creates new user in database table 'users'. Writes user values to
     * database.
     *
     * @param username not null
     * @param email not null
     * @param password not null
     * @param credit fixed to 50 for initial creation of user
     * @return true
     */
    public boolean createUser(String username, String email, String password, int credit) {
        try {
            dbc.open();
            String sql = "INSERT INTO users VALUES (null,?,?,?,?,false);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, username);
            s.setString(2, email);
            s.setString(3, password);
            s.setInt(4, credit);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    /**
     * Reads all possible bottoms objects.
     *
     * @return An ArrayList containing all bottoms as objects with ID, name and
     * price.
     */
    public List<Bottoms> getAllBottoms() {
        List<Bottoms> bottoms = new ArrayList();

        try {
            dbc.open();
            String sql = "select * from bottoms;";
            ResultSet resultset = dbc.query(sql);
            while (resultset.next()) {
                int bottomsID = resultset.getInt("bottomsID");
                String name = resultset.getString("b_name");
                int price = resultset.getInt("b_price");
                Bottoms b = new Bottoms(bottomsID, name, price);
                bottoms.add(b);
            }
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bottoms;
    }

    /**
     * Reads all possible toppings objects.
     *
     * @return An ArrayList containing all toppings as objects with ID, name and
     * price.
     */
    public List<Toppings> getAllToppings() {
        List<Toppings> toppings = new ArrayList();
        try {
            dbc.open();
            String sql = "select * from toppings;";
            ResultSet resultset = dbc.query(sql);
            while (resultset.next()) {
                int toppingsID = resultset.getInt("toppingsID");
                String name = resultset.getString("t_name");
                int price = resultset.getInt("t_price");
                Toppings t = new Toppings(toppingsID, name, price);
                toppings.add(t);
            }
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return toppings;
    }

    /**
     * Reads all User objects.
     *
     * @return An ArrayList containing all users as objects with username,
     * email, password, credit, adminstatus and userID.
     */
    public List<User> getUsers() {
        List<User> listOfUsers = new ArrayList();
        try {
            dbc.open();
            String sql = " select * from users;";
            ResultSet resultset = dbc.query(sql);
            while (resultset.next()) {
                String u_username = resultset.getString("u_username");
                String u_email = resultset.getString("u_email");
                String u_psw = resultset.getString("u_password");
                int credit = resultset.getInt("u_credit");
                boolean admin = resultset.getBoolean("admin");
                int id = resultset.getInt("userID");
                User user = new User(u_username, u_email, u_psw, credit, admin, id);
                listOfUsers.add(user);
            }
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOfUsers;
    }

    /**
     * Deletes a user from the database table 'users'.
     *
     * @param userID always 1 or higher
     */
    public void deleteUser(int userID) {
        try {
            dbc.open();
            String sql = "delete from users where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads Bottom object with id, name and price from database table
     * 'bottoms'.
     *
     * @param bottomsID always 1 or higher
     * @return Bottom object with id, name and price.
     */
    public Bottoms findBottom(int bottomsID) {
        Bottoms res = null;
        try {
            dbc.open();
            String sql = "select * from bottoms where bottomsID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, bottomsID);
            ResultSet resultset = s.executeQuery();
            resultset.next();
            String name = resultset.getString("b_name");
            int price = resultset.getInt("b_price");
            res = new Bottoms(bottomsID, name, price);
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    /**
     * Reads Topping object with id, name and price from database table
     * 'toppings'.
     *
     * @param toppingsID always 1 or higher
     * @return Topping object with id, name and price.
     */
    public Toppings findTopping(int toppingsID) {
        Toppings res = null;
        try {
            dbc.open();
            String sql = "select * from toppings where toppingsID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, toppingsID);
            ResultSet resultset = s.executeQuery();
            resultset.next();
            String name = resultset.getString("t_name");
            int price = resultset.getInt("t_price");
            res = new Toppings(toppingsID, name, price);
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    /**
     * Changes credit on user account.
     *
     * @param user not null
     * @param credit new creditvalue
     */
    public void setCreditToUser(User user, int credit) {
        try {
            dbc.open();
            String sql = "update users set u_credit =? where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, credit);
            s.setInt(2, user.getUserID());
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Adds order to the SQL database.
     *
     * @param price is calculated in the PlaceOrderServlet.
     * @param userID always 1 or higher. Is the ID of the user in the given
     * session.
     */
    public void addOrder(int price, int userID) {
        try {
            dbc.open();
            String sql = " INSERT INTO orders VALUES (null,?,?);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, price);
            s.setInt(2, userID);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns an int that represents a orderID based on a userID.
     *
     * @param userID always 1 or higher. Is the ID of the user in the given
     * session.
     * @return int orderID of the last order the user of the given userID made.
     */
    public int getOrderID(int userID) {
        int orderID = 0;
        try {
            dbc.open();
            String sql = "SELECT orderID from orders where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);
            ResultSet resultset = s.executeQuery();
            resultset.last();
            orderID = resultset.getInt("orderID");
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orderID;
    }

    /**
     * Inserts an orderitem to the database. All orderitems are attached to a
     * specific order.
     *
     * @param orderID always 1 or higher.
     * @param toppingsID always 1 or higher.
     * @param bottomsID always 1 or higher.
     * @param cupcakePrice never supposed to be a negative number.
     * @param quantity always 1 or higher.
     */
    public void addOrderItem(int orderID, int toppingsID, int bottomsID, int cupcakePrice, int quantity) {
        try {
            dbc.open();
            String sql = "INSERT INTO orderitems VALUES (null,?,?,?,?,?);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, orderID);
            s.setInt(2, toppingsID);
            s.setInt(3, bottomsID);
            s.setInt(4, cupcakePrice);
            s.setInt(5, quantity);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Finds all orders for the given userID. The list is used to show the user
     * all of her/his orders if there are any.
     *
     * @param userID given UserID of the UserID in the current session, always 1
     * or higher.
     * @return returns List of Orders. Can be null. (If no orders are placed as
     * of yet)
     */
    public List<Order> showOrdersForUser(int userID) {
        List<Order> userOrders = new ArrayList();
        try {
            dbc.open();
            String sql = "select * from orders where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);
            ResultSet resultset = s.executeQuery();
            while (resultset.next()) {
                int orderID = resultset.getInt("orderID");
                int userIDd = resultset.getInt("userID");
                int price = resultset.getInt("totalprice");
                Order o = new Order(orderID, userIDd, price);
                userOrders.add(o);
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userOrders;
    }

    /**
     * Returns a list of cupcakes, for a given orderID. This list is shown to
     * the user, in his orderdetails.
     *
     * @param orderID this is the ID you give, to get the list of cakes for
     * given ID. ID always 1 or higher.
     * @return List of cupcakes.
     */
    public List<CupCake> OrderDetailsUser(int orderID) {
        List<CupCake> userOrder = new ArrayList();
        try {
            dbc.open();
            String sql = "SELECT * FROM cupcake.orderitems, bottoms, toppings "
                    + "where bottoms.bottomsID = orderitems.bottomsID "
                    + "and toppings.toppingsID = orderitems.toppingsID "
                    + "and orderitems.orderID=?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, orderID);
            ResultSet resultset = s.executeQuery();
            while (resultset.next()) {
                int bottomsID = resultset.getInt("bottomsID");
                String b_name = resultset.getString("b_name");
                int b_price = resultset.getInt("b_price");

                int toppingsID = resultset.getInt("toppingsID");
                String t_name = resultset.getString("t_name");
                int t_price = resultset.getInt("t_price");

                int price = resultset.getInt("cupcakeprice");
                int quantity = resultset.getInt("quantity");
                CupCake c = new CupCake(new Bottoms(bottomsID, b_name, b_price), new Toppings(toppingsID, t_name, t_price), price, quantity);
                userOrder.add(c);
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userOrder;
    }

    /**
     * Makes a list of all orders in the SQL database.
     *
     * @return a list of all orders in the database
     */
    public List<Order> AllOrders() {
        List<Order> allOrders = new ArrayList();
        try {
            dbc.open();
            String sql = "select * from orders";
            ResultSet resultset = dbc.query(sql);
            while (resultset.next()) {
                int orderID = resultset.getInt("orderID");
                int userIDd = resultset.getInt("userID");
                int price = resultset.getInt("totalprice");
                Order o = new Order(orderID, userIDd, price);
                allOrders.add(o);
            }
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allOrders;
    }

    /**
     * Updates the total price of an order. Voidtype method that updates the
     * total price of an order in the SQL database.
     *
     * @param price userinput
     * @param orderID is always 1 or higher.
     */
    public void updateTotalPrice(int price, int orderID) {
        try {
            dbc.open();
            String sql = "update orders set totalprice=? where orderID=?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, price);
            s.setInt(2, orderID);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Inserts a Bottom to the SQL database. Voidtype method that inserts a new
     * Bottom to the SQL database, using String name and int price.
     *
     * @param name cannot be null.
     * @param price
     */
    public void addBottom(String name, int price) {
        try {
            dbc.open();
            String sql = "INSERT INTO bottoms VALUES (?,?);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, name);
            s.setInt(2, price);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Inserts a Topping to the SQL database. Voidtype method that inserts a new
     * Topping to the SQL database, using String name and int price.
     *
     * @param name cannot be null.
     * @param price
     */
    public void addTopping(String name, int price) {
        try {
            dbc.open();
            String sql = "INSERT INTO toppings VALUES (?,?);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, name);
            s.setInt(2, price);
            s.executeUpdate();
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a user from the database. Finds a user in the SQL database using
     * a String emailaddress.
     *
     * @param emailaddress The parameter cannot be.
     * @return should return a user, that isn't null.
     */
    public User getUser(String emailaddress) {
        User user = null;
        try {
            dbc.open();
            String sql = " SELECT * from users where u_email =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, emailaddress);
            ResultSet resultset = s.executeQuery();
            while (resultset.next()) {
                String username = resultset.getString("u_username");
                int userID = resultset.getInt("userID");
                String email = resultset.getString("u_email");
                String psw = resultset.getString("u_password");
                int credit = resultset.getInt("u_credit");
                user = new User(username, email, psw, credit, false, userID);
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * Returns a user from the database. Finds a user in the SQL database using
     * an int userID.
     *
     * @param userID The parameter is always 1 or higher.
     * @return should return a user, that isn't null.
     */
    public User getUser(int userID) {
        User user = null;
        try {
            dbc.open();
            String sql = " SELECT * from users where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);
            ResultSet resultset = s.executeQuery();
            while (resultset.next()) {
                String username = resultset.getString("u_username");
                String email = resultset.getString("u_email");
                String psw = resultset.getString("u_password");
                int credit = resultset.getInt("u_credit");
                user = new User(username, email, psw, credit, false, userID);
            }
            s.close();
            dbc.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
