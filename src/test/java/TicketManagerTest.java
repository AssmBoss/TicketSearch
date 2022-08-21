import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    Ticket ticket0 = new Ticket(0, 400, "Сочи", "Казань", 90);
    Ticket ticket1 = new Ticket(1, 100, "Москва", "Казань", 60);
    Ticket ticket2 = new Ticket(2, 400, "Сочи", "Казань", 80);
    Ticket ticket3 = new Ticket(3, 200, "Ростов", "Уфа", 180);
    Ticket ticket4 = new Ticket(4, 200, "Сочи", "Казань", 120);
    Ticket ticket5 = new Ticket(5, 600, "Воронеж", "Норильск", 60);
    Ticket ticket6 = new Ticket(6, 500, "Ростов", "Уфа", 100);
    Ticket ticket7 = new Ticket(7, 300, "Ростов", "Уфа", 150);

    @Test
    public void shouldFindThreeTicketsAndSortArray() {
        TicketRepository testRepository = new TicketRepository();
        TicketManager manager = new TicketManager(testRepository);
        TicketByFlightTimeComparator comparator = new TicketByFlightTimeComparator();

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket2, ticket0, ticket4};
        Ticket[] actual = manager.findAll("Сочи", "Казань", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicket() {
        TicketRepository testRepository = new TicketRepository();
        TicketManager manager = new TicketManager(testRepository);
        TicketByFlightTimeComparator comparator = new TicketByFlightTimeComparator();

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("Москва", "Казань", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTickets() {
        TicketRepository testRepository = new TicketRepository();
        TicketManager manager = new TicketManager(testRepository);
        TicketByFlightTimeComparator comparator = new TicketByFlightTimeComparator();

        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("Москва", "Уфа", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
