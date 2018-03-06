
package Entity;


public class Order {
    
    int orderID;
    int userID;
    int totalprice;

    public Order(int orderID, int userID, int totalprice) {
        this.orderID = orderID;
        this.userID = userID;
        this.totalprice = totalprice;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getTotalprice() {
        return totalprice;
    }
    
    
    
}
