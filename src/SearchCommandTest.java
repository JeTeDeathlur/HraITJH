import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchCommandTest {

    @Test
    void testSearchRoomForItem() {

        Player player = new Player(new Room("Test Room", "Testovací místnost"));
        Item item = new Item("Klíč", "Klíč k něčemu");
        player.getCurrentRoom().addItem(item);


        SearchCommand searchCommand = new SearchCommand(player, "místnost");
        searchCommand.execute();


        assertTrue(player.getCurrentRoom().getItems().contains(item));
    }

    @Test
    void testSearchForNonExistingItem() {

        Player player = new Player(new Room("Test Room", "Testovací místnost"));

        SearchCommand searchCommand = new SearchCommand(player, "Neexistující Předmět");
        searchCommand.execute();


        assertFalse(player.getCurrentRoom().getItems().stream().anyMatch(item -> item.getName().equals("Neexistující Předmět")));
    }
}
