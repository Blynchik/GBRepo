package hw4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, представляющий покупателя.
 */
public class Customer {
    public int id;
    public TicketBase tickets;
    public CashProvider cash;

    /**
     * Конструктор класса Customer.
     *
     * @param tickets коллекция билетов, на которую имеет доступ покупатель
     */
    public Customer(TicketBase tickets){
        this.tickets = tickets;
        this.cash = new CashProvider();
    }

    /**
     * Метод для покупки билета.
     *
     * @param ticket билет, который нужно купить
     * @return true, если покупка прошла успешно, иначе false
     */
    public boolean buyTicket(Ticket ticket){
        boolean doubleTicket = false;
        System.out.println("Покупка билета...");

        // Проверка, есть ли уже такой билет в коллекции покупателя
        for(Ticket t : tickets.tickets){
            if(t.equals(ticket)){
                doubleTicket = true;
            }
        }

        // Проверка авторизации и доступа к средствам
        if(!doubleTicket && cash.authorization(this) && cash.buy(ticket.price)){
            System.out.println("Билет куплен");

            // Обновление статуса билета и получение информации о нем
            TicketProvider ticketProvider = new TicketProvider(this.tickets);
            ticketProvider.updateTicketStatus(ticket);
            ticketProvider.getTicket(ticket.rootNumber);

            // Добавление билета в коллекцию покупателя
            tickets.tickets.add(ticket);

            return true;
        }

        System.out.println("Ошибка");
        return false;
    }

    /**
     * Метод для поиска билетов по дате и номеру маршрута.
     *
     * @param date        дата, на которую нужно найти билеты
     * @param rootNumber  номер маршрута, на который нужно найти билеты
     * @return список найденных билетов
     */
    public List<Ticket> search(Date date, long rootNumber){
        List<Ticket> findTickets = new ArrayList<>();
        System.out.println("Поиск билета...");

        // Поиск билетов по заданным критериям
        for(Ticket t : tickets.tickets){
            if(t.date.equals(date) && t.rootNumber == rootNumber){
                findTickets.add(t);
            }
        }

        System.out.println("Результат");
        return findTickets;
    }
}