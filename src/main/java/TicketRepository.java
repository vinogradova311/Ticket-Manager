public class TicketRepository {

    protected Ticket[] tickets = new Ticket[0];


    public Ticket[] findById(int id) {

        for (Ticket item : tickets) {
            if (item.getId() == id) {

                return tickets;
            }
        }
        return null;
    }

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = item;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

}
