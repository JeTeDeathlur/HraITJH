import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class UseCommandTest {

    @Test
    public void testExecute_withValidItem_shouldPrintOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Player player = new Player(new Room("Testovací místnost", "Test popis"));
        Item item = new Item("Klíč", "Klíč k odemčení místnosti");
        player.getInventory().addItem(item);


        UseCommand useCommand = new UseCommand(player, "Klíč");
        useCommand.execute();

        String expectedOutput = "Odemkl jsi dveře od hlavní cely a jsi na chodbách. Kam chceš jít teď?\n";
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }
}
