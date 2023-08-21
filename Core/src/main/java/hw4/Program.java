package hw4;

public class Program {

    public static void main(String[] args) {
        TicketBase ticketBase = new TicketBase();
        Customer customer = new Customer(ticketBase);
        Ticket notValidTicket = new Ticket();
        notValidTicket.rootNumber = 234L;
        ticketBase.tickets.add(notValidTicket);
        customer.id = 1;
        Ticket validTicket = new Ticket();
        validTicket.rootNumber = 1;
        customer.buyTicket(validTicket);
        System.out.println("+++++++++++++++++++++++");
        System.out.println(customer.search(notValidTicket.date, 234));
        System.out.println("+++++++++++++++++++++++");
        System.out.println(ticketBase.tickets);
    }
}
