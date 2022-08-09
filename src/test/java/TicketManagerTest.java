import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    Ticket ticket0 = new Ticket(0, 400, "Сочи", "Казань", 80);
    Ticket ticket1 = new Ticket(1, 100, "Москва", "Казань", 60);
    Ticket ticket2 = new Ticket(2, 400, "Сочи", "Казань", 90);
    Ticket ticket3 = new Ticket(3, 200, "Ростов", "Уфа", 180);
    Ticket ticket4 = new Ticket(4, 200, "Сочи", "Казань", 120);
    Ticket ticket5 = new Ticket(5, 600, "Воронеж", "Норильск", 60);
    Ticket ticket6 = new Ticket(6, 500, "Ростов", "Уфа", 100);
    Ticket ticket7 = new Ticket(7, 300, "Ростов", "Уфа", 150);

    @Test
    public void shouldFindAllAndSortArray() {
        TicketRepository testRepository = new TicketRepository();
        TicketManager manager = new TicketManager(testRepository);
        manager.add(ticket0);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket4, ticket0,ticket2};
        Ticket[] actual = manager.findAll("Сочи", "Казань");
        Assertions.assertArrayEquals(expected, actual);

        Ticket[] expected1 = {ticket3,ticket7, ticket6};
        Ticket[] actual1 = manager.findAll("Ростов", "Уфа");
        Assertions.assertArrayEquals(expected1, actual1);
    }
}
