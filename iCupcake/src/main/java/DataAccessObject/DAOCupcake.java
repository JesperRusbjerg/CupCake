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
                int userID = resultset.getInt("userID");
                int credit = resultset.getInt("u_credit");
                boolean admin = resultset.getBoolean("admin");
                res = new User(u_email, u_psw, credit, admin, userID);
            }
            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public boolean createUser(String email, String password, int credit) {
        try {
            dbc.open();
            String sql = "INSERT INTO users VALUES (null,?,?,?,false);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, email);
            s.setString(2, password);
            s.setInt(3, credit);
            s.executeUpdate();

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }

//       public List<CupCake> getCupCakes()
//    {
//        List<CupCake> cupcakes = new ArrayList();
//
//        try
//        {
//            dbc.open();
//
//            String sql = "select * from cupcakes;";
//
//            ResultSet resultset = dbc.query(sql);
//
//            while (resultset.next())
//            {
//                
//                String name = resultset.getString("c_name");
//                int price = resultset.getInt("c_price");
//
//                CupCake c = new CupCake(name, price);
//
//                cupcakes.add(c);
//            }
//        }
//        catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//
//        return cupcakes;
//    }
    public List<Bottoms> getAllBottoms() {
        List<Bottoms> bottoms = new ArrayList();

        try {
            dbc.open();

            String sql = "select * from bottoms;";

            ResultSet resultset = dbc.query(sql);

            while (resultset.next()) {

                String name = resultset.getString("b_name");
                int price = resultset.getInt("b_price");

                Bottoms b = new Bottoms(name, price);

                bottoms.add(b);
            }
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return bottoms;
    }

    public List<Toppings> getAllToppings() {
        List<Toppings> toppings = new ArrayList();

        try {
            dbc.open();

            String sql = "select * from toppings;";

            ResultSet resultset = dbc.query(sql);

            while (resultset.next()) {

                String name = resultset.getString("t_name");
                int price = resultset.getInt("t_price");

                Toppings t = new Toppings(name, price);

                toppings.add(t);
            }

            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return toppings;
    }

    public List<User> getUsers() {

        List<User> a = new ArrayList();
        try {
            dbc.open();

            String sql = " select * from users;";
            ResultSet resultset = dbc.query(sql);

            while (resultset.next()) {

                String u_email = resultset.getString("u_email");
                String u_psw = resultset.getString("u_password");
                int credit = resultset.getInt("u_credit");
                boolean admin = resultset.getBoolean("admin");
                int id = resultset.getInt("userID");
                User x = new User(u_email, u_psw, credit, admin, id);
                a.add(x);
            }

            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public void deleteUser(int userID) {

        try {
            dbc.open();

            String sql = "delete from users where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);

            s.executeUpdate();

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public int bottomPrice(String name) {
        int price = 0;
        try {

            dbc.open();

            String sql = "select b_price from bottoms where b_name =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, name);

            ResultSet resultset = s.executeQuery();
            resultset.next();

            price = resultset.getInt("b_price");

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return price;
    }

    public int toppingPrice(String name) {
        int price = 0;
        try {

            dbc.open();

            String sql = "select t_price from toppings where t_name =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, name);

            ResultSet resultset = s.executeQuery();

            resultset.next();

            price = resultset.getInt("t_price");

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return price;
    }

    public void setCreditToUser(User u, int credit) {
        try {

            dbc.open();

            String sql = "update users set u_credit =? where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, credit);
            s.setInt(2, u.getUserID());
            s.executeUpdate();

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public int getOrderID(int userID) {
        int index = 0;
        try {
            dbc.open();

            String sql = " SELECT orderID from orders where userID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, userID);
            ResultSet resultset = s.executeQuery();

            while (resultset.next()) {

                index = resultset.getInt("orderID");
            }
            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return index;
    }

    public void addOrderItem(int orderID, String bottom, String topping, int cupcakePrice, int amount) {
        try {
            dbc.open();

            String sql = " INSERT INTO orderitems VALUES (null,?,?,?,?,?);";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, orderID);
            s.setString(2, bottom);
            s.setString(3, topping);
            s.setInt(4, cupcakePrice);
            s.setInt(5, amount);

            s.executeUpdate();

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Order> showOrdersForUser(int userID) {
        List<Order> temp = new ArrayList();
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
                temp.add(o);
            }
            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public List<CupCake> OrderDetailsUser(int orderID) {
        List<CupCake> temp = new ArrayList();

        try {

            dbc.open();

            String sql = "select * from orderitems where orderID =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, orderID);
            ResultSet resultset = s.executeQuery();

            while (resultset.next()) {

                String bottom = resultset.getString("bottom");
                String topping = resultset.getString("topping");
                int price = resultset.getInt("cupcakeprice");
                int amount = resultset.getInt("amountofcakes");
                CupCake c = new CupCake(bottom, topping, price, amount);
                temp.add(c);
            }
            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public List<Order> AllOrders() {
        List<Order> temp = new ArrayList();
        try {

            dbc.open();

            String sql = "select * from orders";
            ResultSet resultset = dbc.query(sql);

            while (resultset.next()) {

                int orderID = resultset.getInt("orderID");
                int userIDd = resultset.getInt("userID");
                int price = resultset.getInt("totalprice");
                Order o = new Order(orderID, userIDd, price);
                temp.add(o);
            }
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    public int findOrderItemNumber(int orderID, String bottom, String topping) {
        int found = 0;
        try {
            dbc.open();
            String sql = "select orderitemID from orderitems where orderID =? and bottom =? and topping =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, orderID);
            s.setString(2, bottom);
            s.setString(3, topping);

            ResultSet resultset = s.executeQuery();

            if (resultset.next()) {

                found = resultset.getInt("orderitemID");
            }
            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return found;
    }

    public void updatePrice(int price, int orderitemID) {

        try {
            dbc.open();

            String sql = "update orderitems set cupcakeprice=? where orderitemID=?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setInt(1, price);
            s.setInt(2, orderitemID);
            s.executeUpdate();

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public User getUser(String emailaddress) {
        User x = null;
        try {
            dbc.open();

            String sql = " SELECT * from users where u_email =?;";
            PreparedStatement s = dbc.getConnection().prepareStatement(sql);
            s.setString(1, emailaddress);
            ResultSet resultset = s.executeQuery();

            while (resultset.next()) {

                int userID = resultset.getInt("userID");
                String email = resultset.getString("u_email");
                String psw = resultset.getString("u_password");
                int credit = resultset.getInt("u_credit");
                x = new User(email, psw, credit, false, userID);
            }

            s.close();
            dbc.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return x;
    }

}
