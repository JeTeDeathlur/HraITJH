import java.util.*;

public class CommandProcessor {
    public Command parseCommand(String input, Player player) {
        String[] commandParts = input.split(" ", 2);
        String command = commandParts[0];
        String argument = commandParts.length > 1 ? commandParts[1] : "";

        switch (command) {
            case "jdi":
                return new GoCommand(player, argument);
            case "mluv":
                return new TalkCommand(player, argument);
            case "pouzij":
                return new UseCommand(player, argument);
            case "prohledej":
                return new SearchCommand(player, argument);
            default:
                System.out.println("Neznámý příkaz.");
                return null;
        }
    }
}
