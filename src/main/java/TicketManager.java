import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket item) {
        repo.save(item);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repo.findAll()) {
            if (matches(item, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket tickets, String searchFrom, String searchTo) {
        if (tickets.getDepartureAirport().contains(searchFrom) && tickets.getArrivalAirport().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}
