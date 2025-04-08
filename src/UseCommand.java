import java.util.*;

class UseCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete použít?");
            return;
        }
        String itemName = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        if (!game.getInventory().hasItem(itemName)) {
            System.out.println("Tento předmět nemáte.");
            return;
        }

        if (itemName.equalsIgnoreCase("Klíč od hlavní cely")) {
            System.out.println("Odemkli jste hlavní celu!");
            game.setUsedKey(true);
        } else if (itemName.equalsIgnoreCase("Jed")) {
            System.out.println("Použili jste jed na kuchaře!");
            System.out.println("Kuchař je mrtvý. Našli jste u něj peněženku.");
            game.getCurrentRoom().addItem(new Item("Peněženka"));
            game.setKilledCook(true);
        } else if (itemName.equalsIgnoreCase("Mapa")) {
            System.out.println("Mapa: Musíš se vrátit do jídelny!");
        } else if (itemName.equalsIgnoreCase("Peněženka")) {
            if (game.getCurrentRoom().getName().equalsIgnoreCase("Kancelář vrátného")) {
                System.out.println("Podplatil jsi vrátného a utekl z vězení! Gratulujeme!");
                System.exit(0);
            } else {
                System.out.println("Tady peníze nepomohou.");
            }
        }
    }
}


