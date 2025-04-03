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

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }
}