
import java.util.*;


public class Room {
    public String name;
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
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
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
