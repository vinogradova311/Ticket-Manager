import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket item1 = new Ticket(246, 1999, "LED", "SVO",90);
    Ticket item2 = new Ticket(249, 1999, "SVO", "LED",90);
    Ticket item3 = new Ticket(12, 5999, "SVO", "LED",80);
    Ticket item4 = new Ticket(1937, 1580, "LED", "VKO",110);
    Ticket item5 = new Ticket(2043, 1580, "LED", "VKO",120);
    Ticket item6 = new Ticket(2, 1799, "LED", "SVO",95);

    @Test
    public void addTest() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Ticket[] expected = {item1, item2, item3, item4,item5, item6,};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
@Test
    public void searchTest() {
    manager.add(item1);
    manager.add(item2);
    manager.add(item3);
    manager.add(item4);
    manager.add(item5);
    manager.add(item6);

    Ticket[] expected = {item6, item1};
    Ticket[] actual = manager.searchBy("LED", "SVO");
    Assertions.assertArrayEquals(expected, actual);
}
    @Test
    public void search2Test() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Ticket[] expected = {item2, item3};
        Ticket[] actual = manager.searchBy("SVO", "LED");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfEqualTest() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Ticket[] expected = {item4, item5};
        Ticket[] actual = manager.searchBy("LED", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotFoundTest() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Ticket[] expected = { };
        Ticket[] actual = manager.searchBy("VKO", "SVO");
        Assertions.assertArrayEquals(expected, actual);
    }

}
