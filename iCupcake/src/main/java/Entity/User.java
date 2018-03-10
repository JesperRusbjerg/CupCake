package Entity;

public class User {

    private String name;
    private String password;
    private int credit;
    boolean admin;
    int userID;

    public User(String name, String password, int credit, boolean admin, int userID) {
        this.name = name;
        this.password = password;
        this.credit = credit;
        this.admin = admin;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getUserID() {
        return userID;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
