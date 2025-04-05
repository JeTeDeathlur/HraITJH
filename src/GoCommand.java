import java.util.*;

class GoCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Kam chcete jít?");
            return;
        }
        String destination = args[1];
        Room nextRoom = game.getCurrentRoom().getExit(destination);

        if (destination.equalsIgnoreCase("Temné chodby") && !game.hasUsedKey()) {
            System.out.println("Nemůžete jít do Temných chodeb bez odemčení hlavní cely!");
            return;
        }

        if (destination.equalsIgnoreCase("Kuchyně") && !game.hasKilledCook()) {
            System.out.println("Nemůžete vstoupit do kuchyně, dokud kuchaře neodstraníte!");
            return;
        }

        if (destination.equalsIgnoreCase("Kancelář vrátného") && !game.hasMoney()) {
            System.out.println("Nemáte peníze na podplacení vrátného. Hra končí.");
            System.exit(0);
        }

        if (nextRoom != null) {
            game.setCurrentRoom(nextRoom);
            System.out.println("Nyní se nacházíte v " + nextRoom.getName());

            if (destination.equalsIgnoreCase("Jídelna")) {
                System.out.println("Kuchař: Co tu děláš?! Okamžitě vypadni!");
                System.out.println("Chcete kuchaře zabít? (ano/ne)");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("ne")) {
                    System.out.println("Vypukla vzpoura! Hra skončila.");
                    System.exit(0);
                } else {
                    System.out.println("Možná by se hodilo podívat se do kuchyně...");
                }
            }
        } else {
            System.out.println("Tam se nemůžete dostat!");
        }
    }
}

