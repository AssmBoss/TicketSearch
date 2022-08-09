public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        if (findById(item.getId()) != null) {
            throw new AlreadyExistsException("Element with id: " + item.getId() + " already exists!");
        }
        Ticket[] tmp = new Ticket[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[items.length - 1];
        int copyToIndex = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Ticket[] getItems() {
        return items;
    }

    public Ticket findById(int id) {
        for (Ticket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
