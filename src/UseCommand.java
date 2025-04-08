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

        Room currentRoom = game.getCurrentRoom();

        if (itemName.equalsIgnoreCase("Klíč od hlavní cely")) {
            System.out.println("Odemkli jste hlavní celu!");
            game.setUsedKey(true);

        } else if (itemName.equalsIgnoreCase("Lahvička s jedem")) {
            if (currentRoom.getName().equalsIgnoreCase("Kuchyně") && !game.hasKilledCook()) {
                System.out.println("Použili jste jed na kuchaře!");
                System.out.println("Kuchař byl zabit. Z kapsy mu vypadla peněženka.");

                game.getInventory().removeItem("Lahvička s jedem");


                game.setKilledCook(true);


                Character cook = currentRoom.getCharacterByName("Kuchař");
                if (cook != null) {
                    currentRoom.removeCharacter(cook);
                }


                currentRoom.addItem(new Item("Peněženka"));

            } else if (game.hasKilledCook()) {
                System.out.println("Kuchař je už mrtvý.");
                game.getCurrentRoom().addItem(new Item("Peněženka"));
            } else {
                System.out.println("Nemůžete použít jed tady.");
            }

        } else if (itemName.equalsIgnoreCase("Mapa")) {
            System.out.println("Mapa: Hlavní cela -> Temné chodby -> Jídelna -> Kuchyně -> Jídelna -> Sklad -> Kancelář vrátného.");

        } else if (itemName.equalsIgnoreCase("Peněženka")) {
            if (currentRoom.getName().equalsIgnoreCase("Kancelář vrátného")) {
                System.out.println("Podplatil jsi vrátného a utekl z vězení! Gratulujeme!");
                System.exit(0);
            } else {
                System.out.println("Tady peníze nepomohou.");
            }

        } else {
            System.out.println("Tento předmět nelze použít.");
        }
    }
}



