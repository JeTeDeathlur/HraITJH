
import java.util.*;
public class Room {
    private String name;
    private String description;
    private List<Item> items;
    private List<Character> characters;
    private Map<String, Room> exits;

    public void describe() {}
    public Room getExit(String direction) { return null; }
    public List<Item> getItems() { return null; }
    public List<Character> getCharacters() { return null; }
}