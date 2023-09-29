package unit.hw3.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.hw3.given.User;
import unit.hw3.given.UserRepository;

public class Sol {
    /**
     * Добавьте функцию в класс UserRepository,
     * которая разлогинивает всех пользователей,
     * кроме администраторов. Для этого, вам
     * потребуется расширить класс User
     * новым свойством, указывающим, обладает ли
     * пользователь админскими правами.
     * Протестируйте данную функцию.
     */

    private UserRepository uRepo;

    @BeforeEach
    void setUp() {
        uRepo = new UserRepository();
        for (int i = 0; i < 10; i++) {
            boolean isAdmin = Math.random() > 0.49;
            User user = new User("Name" + i, "password" + i, isAdmin);
            user.authenticate("Name" + i, "password" + i);
            uRepo.addUser(user);
        }
    }

    @Test
    void notAdminLogOut_Test() {
        uRepo.notAdminLogOut();

        Assertions.assertTrue(this.uRepo.getData().stream()
                .allMatch(User::getAdmin));

        Assertions.assertTrue(this.uRepo.getData().stream()
                .allMatch(User::isAuthenticate));
    }
}
