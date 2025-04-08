import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    /**
     * Inicializace nové hry před každým testem
     */
    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    /**
     * Testuje, že se hráč nachází ve výchozí místnosti
     */
    @Test
    public void testInitialRoom() {
        assertEquals("Hlavní cela", game.getCurrentRoom().getName());
    }

    /**
     * Testuje, že klíč od hlavní cely je ve výchozí místnosti a lze ho sebrat
     */
    @Test
    public void testTakeItem() {
        Room room = game.getCurrentRoom();
        assertTrue(room.hasItem("Klíč od hlavní cely"));
    }

    /**
     * Testuje použití klíče od hlavní cely
     */
    @Test
    public void testUseKey() {
        game.getInventory().addItem(new Item("Klíč od hlavní cely"));
        UseCommand use = new UseCommand();
        use.execute(game, new String[]{"použij", "Klíč od hlavní cely"});
        assertTrue(game.hasUsedKey());
    }

    /**
     * Testuje přechod do vedlejší místnosti
     */
    @Test
    public void testGoCommand() {
        game.setUsedKey(true);
        GoCommand go = new GoCommand();
        go.execute(game, new String[]{"jdi", "Temné chodby"});
        assertEquals("Temné chodby", game.getCurrentRoom().getName());
    }

    /**
     * Testuje neplatný vstup u příkazu "jdi"
     */
    @Test
    public void testInvalidGoCommand() {
        GoCommand go = new GoCommand();
        go.execute(game, new String[]{"jdi"});
        assertEquals("Hlavní cela", game.getCurrentRoom().getName());
    }

    /**
     * Testuje chování při použití neexistujícího předmětu
     */
    @Test
    public void testUseInvalidItem() {
        UseCommand use = new UseCommand();
        use.execute(game, new String[]{"použij", "Neexistující věc"});
        assertFalse(game.hasUsedKey());
    }

    /**
     * Testuje správnou detekci dialogu s vrátným
     */
    @Test
    public void testTalkToGuard() {
        game.setCurrentRoom(game.getCurrentRoom().getExits().get("Temné chodby"));
        game.setCurrentRoom(game.getCurrentRoom().getExits().get("Jídelna"));
        game.setCurrentRoom(game.getCurrentRoom().getExits().get("Sklad"));
        game.setCurrentRoom(game.getCurrentRoom().getExits().get("Kancelář vrátného"));
        Character vratny = game.getCurrentRoom().getCharacterByName("Vrátný");
        assertNotNull(vratny);
        assertEquals("Zkorumpovaný vrátný", vratny.getDialogue());
    }
}
