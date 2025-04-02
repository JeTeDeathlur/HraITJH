import java.util.*;

public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Character> characters;
    private Map<String, Room> exits;
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.exits = new HashMap<>();
    }

    public void describe() {
        System.out.println(description);
        System.out.println("V této místnosti se nachází:");
        if (items.isEmpty()) {
            System.out.println("Žádné předměty.");
        } else {
            for (Item item : items) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
        if (characters.isEmpty()) {
            System.out.println("Žádné postavy.");
        } else {
            for (Character character : characters) {
                System.out.println("- Postava: " + character.getName() + ": " + character.getDescription());
            }
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }


    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    public void removeItem(Item item) {
        items.remove(item);
    }


    public void addCharacter(Character character) {
        characters.add(character);
    }


    public List<Character> getCharacters() {
        return characters;
    }


    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }


    public Room getExit(String direction) {
        return exits.get(direction);
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
