import java.util.*;

import java.util.*;

public class CommandProcessor {
    public Command parseCommand(String input, Player player) {
        String[] inputParts = input.split(" ", 2);
        String command = inputParts[0];

        switch (command.toLowerCase()) {
            case "jdi":
                return new GoCommand(player, inputParts[1]);
            case "prohledej":
                return new SearchCommand(player, inputParts[1]);
            case "vezmi":
                return new TakeCommand(player, inputParts[1]);
            case "mluv":
                return new TalkCommand(player, inputParts[1]);
            case "pouzij":
                return new UseCommand(player, inputParts[1]);
            default:
                System.out.println("Neznámý příkaz.");
                return null;
        }
    }
}

