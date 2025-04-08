import java.util.*;
/**
 * Příkaz pro sebrání předmětu z aktuální místnosti
 */
class TakeCommand extends Command {
    /**
     * Provádí akci sebrání předmětu a přidání do inventáře.
     * @param game instance hry
     * @param args vstupní argumenty (např. "vezmi Mapa")
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete vzít?");
            return;
        }

        String itemName = args[1];
        Room room = game.getCurrentRoom();
        Item itemToTake = null;

        for (Item item : room.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToTake = item;
                break;
            }
        }

        if (itemToTake != null) {
            game.getInventory().addItem(itemToTake);
            room.removeItem(itemToTake);
            System.out.println("Sebrali jste: " + itemToTake.getName());
        } else {
            System.out.println("Tento předmět zde není.");
        }
    }
}


