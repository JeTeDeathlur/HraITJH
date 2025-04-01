import java.util.Scanner;


public class Game {
    private Scanner scanner;
    private Player player;
    private boolean gameRunning;

    public Game(Player player) {
        scanner = new Scanner(System.in);
        gameRunning = true;
    }

    public void start() {

        Room mainCell = new Room("Hlavní cela", "Jsi v hlavní cele vězení. Všude je tma a zatuchlý vzduch.");
        Room darkCorridor = new Room("Temné chodby", "Chodby vězení jsou úzké a temné.");


        Item key = new Item("Klíč", "Klíč, který otevírá zámek v hlavní cele.");


        mainCell.addItem(key);

        Character guard = new Character("Strážce", "Strážce vězení, který patroluje chodby.");


        mainCell.addCharacter(guard);

        mainCell.addExit("jdi temné chodby", darkCorridor);


        player = new Player(mainCell);


        System.out.println("Vítej ve hře 'Útěk z vězení'.");
        System.out.println("Vítej ve hře 'Útěk z vězení'.");
        System.out.println("Zde je seznam příkazů, které můžeš použít:");
        System.out.println("- 'prohledej místnost' - Prozkoumej místnost.");
        System.out.println("- 'vezmi <předmět>' - Sebrat předmět.");
        System.out.println("- 'jdi <směr>' - Přejít do jiné místnosti.");
        System.out.println("- 'mluv <postava>' - Mluvit s postavou.");
        System.out.println("- 'použij <předmět>' - Použít předmět z inventáře.");
        System.out.println("- 'konec' - Ukončit hru.");
        System.out.println("Co chceš dělat?");

        while (gameRunning) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();
            processCommand(command);
        }
    }

    private void processCommand(String command) {
        String[] commandParts = command.split(" ", 2);
        String action = commandParts[0];
        String argument = (commandParts.length > 1) ? commandParts[1] : "";

        switch (action) {
            case "prohledej":
                if (argument.equalsIgnoreCase("místnost")) {
                    player.getCurrentRoom().describe();
                } else {
                    System.out.println("Neznámý příkaz.");
                }
                break;
            case "vezmi":
                if (argument.isEmpty()) {
                    System.out.println("Musíš specifikovat, co chceš vzít.");
                } else {
                    player.takeItem(argument);
                }
                break;
            case "jdi":
                if (argument.isEmpty()) {
                    System.out.println("Musíš specifikovat směr.");
                } else {
                    player.moveTo(player.getCurrentRoom().getExit(argument));
                }
                break;
            case "mluv":
                if (argument.isEmpty()) {
                    System.out.println("Musíš specifikovat, s kým chceš mluvit.");
                } else {
                    player.talkToCharacter(argument);
                }
                break;
            case "konec":
                gameRunning = false;
                System.out.println("Hra byla ukončena.");
                break;
            default:
                System.out.println("Neznámý příkaz.");
        }
    }
}