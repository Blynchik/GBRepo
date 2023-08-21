package hw4;

/**
 * Класс, представляющий провайдера платежей.
 **/
public class CashProvider {
    public long card;
    public long hashCard;
    public boolean isAuthorization;

    /**
     * Метод для совершения покупки.
     *
     * @param price стоимость покупки
     * @return true, если покупка прошла успешно, иначе false
     **/
    public boolean buy(double price) {
        System.out.println("Проверка транзакции");
        return true;
    }

    /**
     * Метод для проверки авторизации покупателя.
     *
     * @param customer покупатель, для которого проверяется авторизация
     * @return true, если авторизация прошла успешно, иначе false
     **/
    public boolean authorization(Customer customer) {
        System.out.println("Проверка авторизации");
        return customer.id > 0;
    }
}