import java.io.*;
import java.util.*;
class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("jdi", new GoCommand());
        commands.put("prohledej", new SearchCommand());
        commands.put("vezmi", new TakeCommand());
        commands.put("mluv", new TalkCommand());
        commands.put("použij", new UseCommand());
    }

    public void processCommand(Game game, String input) {
        String[] parts = input.split(" ", 2);
        Command command = commands.get(parts[0]);
        if (command != null) {
            command.execute(game, parts);
        } else {
            System.out.println("Neznámý příkaz.");
        }
    }
}