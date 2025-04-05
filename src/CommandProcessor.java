import java.io.*;
import java.util.*;
class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("jdi", new GoCommand());
        commands.put("prohledej", new SearchCommand());
        commands.put("vezmi", new TakeCommand());
        commands.put("mluv", new TalkCommand());
        commands.put("pouzij", new UseCommand());
    }

    public void processCommand(Game game, String input) {
        String[] parts = input.split(" ", 2);
        String commandName = parts[0];
        String[] args = input.split(" ");
        Command command = commands.get(commandName);

        if (command != null) {
            command.execute(game, args);
        } else {
            System.out.println("Neznámý příkaz.");
        }
    }
}
