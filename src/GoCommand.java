import java.util.*;
/**
 * Příkaz pro přechod do jiné místnosti
 */
class GoCommand extends Command {
    /**
     * Provádí příkaz jdi do místnosti, pokud je dostupná.
     * @param game aktuální instance hry
     * @param args vstupní argumenty (např. "jdi Sklad")
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Kam chcete jít?");
            return;
        }
        String destination = args[1];
        Room nextRoom = null;
        for (Room room : game.getCurrentRoom().getExits().values()) {
            if (room.getName().equalsIgnoreCase(destination)) {
                nextRoom = room;
                break;
            }
        }

        if (destination.equalsIgnoreCase("Temné chodby") && !game.hasUsedKey()) {
            System.out.println("Nemůžete jít do Temných chodeb bez odemčení hlavní cely!");
            return;
        }

        if (nextRoom != null) {
            game.setCurrentRoom(nextRoom);
            System.out.println("Nyní se nacházíte v " + nextRoom.getName());
            if (destination.equalsIgnoreCase("Jídelna") && game.hasKilledCook()) {
                System.out.println("Jídelna je prázdná a tichá po smrti kuchaře...");
            } else if (destination.equalsIgnoreCase("Jídelna")) {
                System.out.println("Mezi vězni se šušká, že tě kuchař chce sníst za pozdní příchod.");
                System.out.println("Chcete kuchaře zabít? (ano/ne)");
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (response.equals("ne")) {
                        System.out.println("Kuchař naběhne do Jídelny z Kuchyně a sní tě za živa! Hra skončila.");
                        System.exit(0);
                    } else if (response.equals("ano")) {
                        System.out.println("Možná by se hodilo podívat se za kuchařem do kuchyně a něco vymyslet...");
                        break;
                    } else {
                        System.out.println("Tato možnost není v nabídce. Zadejte prosím 'ano' nebo 'ne':");
                    }
                }

            }
        } else {
            System.out.println("Tam se nemůžete dostat!");
        }
    }
}