
package Entity;


public class CupCake {

private final String bottom;
private final String top;
private final int price;
private int amount;

    public CupCake(String bottom, String top, int price, int amount) {
        this.bottom = bottom;
        this.top = top;
        this.price = price;
        this.amount = amount;
    }

    public String getBottom() {
        return bottom;
    }

    public String getTop() {
        return top;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    

    


    
}
