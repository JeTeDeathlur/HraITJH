import java.util.*;

class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public CommandProcessor() {
        commands.put("jdi", new GoCommand());
        commands.put("prohledej", new SearchCommand());
        commands.put("vezmi", new TakeCommand());
        commands.put("mluv", new TalkCommand());
        commands.put("použij", new UseCommand());
        commands.put("pouzij", new UseCommand());
    }

    public void processCommand(Game game, String input) {
        String[] parts = input.trim().split(" ", 2);
        String command = parts[0].toLowerCase();
        String[] args = (parts.length > 1) ? new String[]{command, parts[1]} : new String[]{command};

        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute(game, args);
        } else {
            System.out.println("Neznámý příkaz.");
        }
    }
}