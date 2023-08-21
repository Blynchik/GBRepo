package hw4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    public int id;
    public TicketBase tickets;
    public CashProvider cash;

    public Customer(TicketBase tickets){
        this.tickets = tickets;
        this.cash = new CashProvider();
    }

    public boolean buyTicket(Ticket ticket){
        boolean doubleTicket = false;
        System.out.println("Покупка билета...");

        for(Ticket t : tickets.tickets){
            if(t.equals(ticket)){
                doubleTicket = true;
            }
        }

        if(!doubleTicket && cash.authorization(this) && cash.buy(ticket.price)){
            System.out.println("Билет куплен");
            TicketProvider ticketProvider = new TicketProvider(this.tickets);
            ticketProvider.updateTicketStatus(ticket);
            ticketProvider.getTicket(ticket.rootNumber);
            tickets.tickets.add(ticket);
            return true;
        }


        System.out.println("Ошибка");
        return false;
    }

    public List<Ticket> search(Date date, long rootNumber){
        List<Ticket> findTickets = new ArrayList<>();
        System.out.println("Поиск билета");

        for(Ticket t : tickets.tickets){
            if(t.date.equals(date) && t.rootNumber == rootNumber){
                findTickets.add(t);
            }
        }
        System.out.println("Результат");
        return findTickets;
    }
}
