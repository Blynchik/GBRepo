package hw4;

import java.util.Date;

public class Ticket {
    public long rootNumber;
    public double price;
    public int place;
    public Date date = new Date();
    public boolean isValid = false;

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
