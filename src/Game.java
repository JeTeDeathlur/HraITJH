import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

class Game {
    private Map<String, Room> rooms = new HashMap<>();
    private Room currentRoom;
    private Inventory inventory = new Inventory();
    private boolean usedKey = false;
    private boolean killedCook = false;
    private boolean hasMoney = false;

    public Game() {
        loadRooms();
        loadCharacters();
        loadItems();
        currentRoom = rooms.get("Hlavní cela");
    }

    private void loadRooms() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/rooms.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Room room = rooms.computeIfAbsent(parts[0], Room::new);
                if (parts.length > 1 && !parts[1].equals("-")) {
                    Room exitRoom = rooms.computeIfAbsent(parts[1], Room::new);
                    room.addExit("dále", exitRoom);
                }
                rooms.put(parts[0], room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCharacters() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/characters.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Character character = new Character(parts[0], parts[1]);
                Room room = rooms.get(parts[2]);
                if (room != null) {
                    room.addCharacter(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/items.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Item item = new Item(parts[0]);
                Room room = rooms.get(parts[1]);
                if (room != null) {
                    room.addItem(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void setUsedKey(boolean usedKey) {
        this.usedKey = usedKey;
    }

    public boolean hasUsedKey() {
        return usedKey;
    }

    public boolean hasKilledCook() {
        return killedCook;
    }

    public void setKilledCook(boolean killedCook) {
        this.killedCook = killedCook;
    }

    public boolean hasMoney() {
        return hasMoney;
    }

    public void setHasMoney(boolean hasMoney) {
        this.hasMoney = hasMoney;
    }

    public void start() {
        System.out.println("Vítejte ve hře Útěk z vězení!");
        System.out.println("Dostupné příkazy:");
        System.out.println("  - jdi <místnost> : Přejděte do jiné místnosti");
        System.out.println("  - prohledej : Prohledejte místnost");
        System.out.println("  - vezmi <předmět> : Vezměte předmět z místnosti");
        System.out.println("  - mluv <postava> : Mluvte s postavou");
        System.out.println("  - použij <předmět> : Použijte předmět");
        System.out.println("  - ukonci : Ukončete hru");

        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();

        while (true) {
            System.out.println("\nNacházíte se v: " + currentRoom.getName());
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("ukonci")) break;

            processor.processCommand(this, input);
        }

        scanner.close();
    }
}
