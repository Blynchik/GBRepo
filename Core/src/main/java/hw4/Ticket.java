package hw4;

import java.util.Date;

/**
 * Класс Ticket представляет собой билет.
 */
public class Ticket {
    public long rootNumber;
    public double price;
    public int place;
    public Date date = new Date();
    public boolean isValid = false;

    /**
     * Возвращает строковое представление билета.
     * @return строковое представление билета.
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "rootNumber=" + rootNumber +
                ", price=" + price +
                ", place=" + place +
                ", date=" + date +
                ", isValid=" + isValid +
                '}';
    }
}
