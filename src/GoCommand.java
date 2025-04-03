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


            if (destination.equalsIgnoreCase("Temné chodby") && !game.getInventory().hasItem("Klíč od hlavní cely")) {
                System.out.println("Musíš nejprve vzít klíč k odemčení hlavní cely.");
                return;
            }

            Room nextRoom = game.getCurrentRoom().exits.get(destination);
            if (nextRoom != null) {
                game.setCurrentRoom(nextRoom);
                if (nextRoom.name.equalsIgnoreCase("Temné chodby")) {
                    System.out.println("Nyní se nacházíte v Temných chodbách.");
                } else {
                    System.out.println("Přesunuli jste se do: " + nextRoom.name);
                }
            } else {
                System.out.println("Tam se nemůžete dostat!");
            }
        }
    }

