import java.util.*;

public class Room {
    private String name;
    private Map<String, Room> exits = new HashMap<>();  // Mapa výstupů z místnosti
    private List<Item> items = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
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


    public Map<String, Room> getExits() {
        return exits;
    }

    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }


    public List<Character> getCharacters() {
        return characters;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {
        characters.remove(character);
    }


    public Character getCharacterByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}

