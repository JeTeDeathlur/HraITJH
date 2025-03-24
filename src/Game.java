import java.util.*;
import java.util.Scanner;


public class Game {
    private Player player;
    private Scanner scanner;

    public Game(Player player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        System.out.println("Vítejte ve hře Útěk z vězení!");
        System.out.println("Tvým úkolem je uniknout z vězení a očistit svoje jméno.");

        while (true) {
            System.out.println("\n-------------------------------------------------");
            player.getCurrentRoom().describe();
            showAvailableActions();
            String command = scanner.nextLine();
            processCommand(command);
        }
    }


    private void showAvailableActions() {
        System.out.println("Co chceš dělat?");
        System.out.println("Dostupné příkazy:");
        System.out.println("1. jdi + místnost (např. jdi temné chodby)");
        System.out.println("2. mluv + jméno postavy (např. mluv kuchař)");
        System.out.println("3. prohledej + objekt (např. prohledej skříň)");
        System.out.println("4. vezmi + předmět (např. vezmi klíč)");
        System.out.println("5. použij + předmět (např. použij klíč)");
        System.out.println("Pro ukončení hry napiš 'konec'.");
    }


    private void processCommand(String command) {
        String[] parts = command.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Neplatný příkaz. Zkus to znovu.");
            return;
        }

        String action = parts[0].toLowerCase();
        String target = parts[1].toLowerCase();

        switch (action) {
            case "jdi":
                moveToRoom(target);
                break;
            case "mluv":
                talkToCharacter(target);
                break;
            case "prohledej":
                searchItem(target);
                break;
            case "vezmi":
                takeItem(target);
                break;
            case "pouzij":
                useItem(target);
                break;
            case "konec":
                System.out.println("Konec hry. Děkujeme za hraní!");
                System.exit(0);
                break;
            default:
                System.out.println("Tento příkaz není podporován.");
        }
    }


    private void moveToRoom(String roomName) {
        Room exitRoom = player.getCurrentRoom().getExit(roomName);
        if (exitRoom != null) {
            player.moveTo(exitRoom);
        } else {
            System.out.println("Tato místnost neexistuje.");
        }
    }


    private void talkToCharacter(String characterName) {
        player.talkToCharacter(characterName);
    }


    private void searchItem(String itemName) {
        player.searchItem(itemName);
    }


    private void takeItem(String itemName) {
        player.takeItem(itemName);
    }


    private void useItem(String itemName) {
        player.useItem(itemName);
    }
}


