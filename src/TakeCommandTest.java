import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TakeCommandTest {
    @Test
    public void testTakeItem() {
        Player player = new Player(new Room("Test Room", "Test room"));
        Item key = new Item("Klíč", "Odemkne dveře.");
        player.getCurrentRoom().addItem(key);

        TakeCommand takeCommand = new TakeCommand(player, "Klíč");
        takeCommand.execute();

        assertNotNull(player.getInventory().getItem("Klíč"));
        assertNull(player.getCurrentRoom().getItem("Klíč"));
    }
}
