import java.io.*;
import java.util.*;

class Room {
    String name;
    List<Item> items = new ArrayList<>();
    List<Character> characters = new ArrayList<>();
    Map<String, Room> exits = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addExit(String direction, Room room) {
        exits.put(room.getName(), room);
    }

    public Room getExit(String destination) {
        return exits.get(destination);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }


    public Character getCharacter(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
}