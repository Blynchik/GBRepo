package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс TicketBase представляет базу данных билетов.
 */
public class TicketBase {
    public List<Ticket> tickets;

    /**
     * Конструктор класса TicketBase.
     * Создает новый экземпляр списка Ticket для хранения билетов.
     */
    public TicketBase() {
        this.tickets = new ArrayList<>();
    }
}
