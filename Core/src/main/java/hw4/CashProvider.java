package hw4;

public class CashProvider {
    public long card;
    public long hashCard;
    public boolean isAuthorization;
    public boolean buy(double price){
        System.out.println("Проверка транзакции");
        return true;
    }

    public boolean authorization(Customer customer){
        System.out.println("Проверка авторизации");
       return customer.id > 0;
    }
}
