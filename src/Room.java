
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
        for (Item item : items) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
        for (Character character : characters) {
            System.out.println("- Postava: " + character.getName() + ": " + character.getDescription());
        }


        System.out.println("\nNapověda:");
        System.out.println("Pro prozkoumání místnosti napiš: prohledej místnost.");

        for (Item item : items) {
            System.out.println("Pro sebrání předmětu " + item.getName() + " napiš: vezmi " + item.getName());
        }
        for (Character character : characters) {
            System.out.println("Pro mluvení s " + character.getName() + " napiš: mluv " + character.getName());
        }

    }
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;

    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }


    public List<Item> getItems() {
        return items;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public String getName() {
        return name;
    }
}


