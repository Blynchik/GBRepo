package hw4;

import java.util.ArrayList;
import java.util.List;

public class TicketProvider {

    public TicketBase ticketBase;

    public TicketProvider(TicketBase ticketBase){
        this.ticketBase = ticketBase;
    }

    public List<Ticket> getTicket(long rootNumber){
        List<Ticket> findTickets = new ArrayList<>();
        System.out.println("Печать билета");

        for(Ticket t : ticketBase.tickets){
            if(t.rootNumber == rootNumber){
                findTickets.add(t);
            }
        }
        return findTickets;
    }

    public boolean updateTicketStatus(Ticket ticket){
        ticket.isValid = !ticket.isValid;
        return true;
    }
}
