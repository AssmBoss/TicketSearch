import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket tckt : repository.getItems()) {
            if (tckt.takeOff == from && tckt.landing == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = tckt;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
