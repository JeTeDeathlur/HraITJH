import java.io.*;
import java.util.*;

class Game {
    private Map<String, Room> rooms = new HashMap<>();
    private Room currentRoom;
    private Inventory inventory = new Inventory();
    private boolean usedKey = false;

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
                Room room = new Room(parts[0]);
                rooms.put(parts[0], room);
                if (parts.length > 1 && !parts[1].equals("-")) {
                    Room exitRoom = rooms.getOrDefault(parts[1], new Room(parts[1]));
                    room.addExit("dále", exitRoom);
                }
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
                if (rooms.containsKey(parts[2])) {
                    rooms.get(parts[2]).addCharacter(character);
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
                if (rooms.containsKey(parts[1])) {
                    rooms.get(parts[1]).addItem(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Room getRoom(String name) {
        return rooms.get(name);
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

    public void start() {
        System.out.println("Vítejte ve hře Útěk z vězení!");
        System.out.println("Dostupné příkazy:");
        System.out.println("  - jdi [místnost] : Přejděte do jiné místnosti");
        System.out.println("  - prohledej : Prohledejte místnost");
        System.out.println("  - vezmi [předmět] : Vezměte předmět z místnosti");
        System.out.println("  - mluv [postava] : Mluvte s postavou");
        System.out.println("  - použij [předmět] : Použijte předmět");
        System.out.println("  - ukonci : Ukončete hru");

        System.out.println("Nacházíte se v: " + currentRoom.name);
        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor = new CommandProcessor();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("ukonci")) break;

            commandProcessor.processCommand(this, input);
        }

        scanner.close();
    }
}
