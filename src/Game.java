import java.util.*;
public class Game {
    private Player player;
    private CommandProcessor commandProcessor;

    public Game(Room startRoom) {
        this.player = new Player(startRoom);
        this.commandProcessor = new CommandProcessor();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nJsi v místnosti: " + player.getCurrentRoom().getName());
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Command command = commandProcessor.parseCommand(input, player);
            if (command != null) {
                command.execute();
            }
        }
        scanner.close();
    }
}
