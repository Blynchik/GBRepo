package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс TicketProvider предоставляет функциональность для получения билетов и обновления их статуса.
 */
public class TicketProvider {
    public TicketBase ticketBase;

    /**
     * Конструктор класса TicketProvider.
     * @param ticketBase объект типа TicketBase, представляющий базу данных билетов.
     */
    public TicketProvider(TicketBase ticketBase) {
        this.ticketBase = ticketBase;
    }

    /**
     * Метод для получения списка билетов по указанному номеру маршрута.
     * @param rootNumber номер маршрута, для которого нужно получить билеты.
     * @return список билетов соответствующих указанному номеру маршрута.
     */
    public List<Ticket> getTicket(long rootNumber) {
        List<Ticket> findTickets = new ArrayList<>();
        System.out.println("Печать билета");
        for(Ticket t : ticketBase.tickets) {
            if(t.rootNumber == rootNumber){
                findTickets.add(t);
            }
        }
        return findTickets;
    }

    /**
     * Метод для обновления статуса билета.
     * @param ticket объект типа Ticket, для которого нужно обновить статус.
     * @return true, если статус билета успешно обновлен, иначе - false.
     */
    public boolean updateTicketStatus(Ticket ticket) {
        ticket.isValid = !ticket.isValid;
        return true;
    }
}
