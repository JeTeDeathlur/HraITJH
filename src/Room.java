import java.util.*;
/**
 * Reprezentuje místnost ve hře, která může obsahovat předměty a postavy.
 */
public class Room {
    private String name;
    private Map<String, Room> exits = new HashMap<>();  // Mapa výstupů z místnosti
    private List<Item> items = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();
    /**
     * Vytvoří místnost se zadaným názvem.
     * @param name název místnosti
     */
    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    /**
     * Vrátí seznam položek v místnosti.
     * @return seznam položek
     */
    public List<Item> getItems() {
        return items;
    }
    /**
     * Přidá položku do místnosti.
     * @param item položka k přidání
     */
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

    /**
     * Vrátí seznam postav v místnosti.
     * @return seznam postav
     */
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

