package unit.hw3.given;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        this.data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void notAdminLogOut() {
        List<User> copy = new ArrayList<>(this.data);
        for(User u : copy){
            if(!u.isAdmin){
                u.isAuthenticate = false;
                this.data.remove(u);
            }
        }
    }

    public List<User> getData() {
        return data;
    }
}