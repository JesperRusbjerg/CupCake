package Entity;

public class User {

    private String username;
    private String email;
    private String password;
    private int credit;
    boolean admin;
    int userID;

    public User(String username, String email, String password, int credit, boolean admin, int userID) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.credit = credit;
        this.admin = admin;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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
