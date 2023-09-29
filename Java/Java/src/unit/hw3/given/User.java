package unit.hw3.given;

public class User {

    String name;
    String password;
    Boolean isAdmin;

    boolean isAuthenticate;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            return this.isAuthenticate = true;
        }
        return this.isAuthenticate = false;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isAuthenticate=" + isAuthenticate +
                '}';
    }
}