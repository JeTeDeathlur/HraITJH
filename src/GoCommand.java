import java.io.*;
import java.util.*;
class GoCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Kam chcete jít?");
            return;
        }
        String destination = args[1];
        Room nextRoom = game.getCurrentRoom().exits.get(destination);
        if (nextRoom != null) {
            game.setCurrentRoom(nextRoom);
            System.out.println("Přesunuli jste se do: " + nextRoom.name);
        } else {
            System.out.println("Tam se nemůžete dostat!");
        }
    }
}