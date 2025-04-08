import java.util.*;

/**
 * Uchovává seznam předmětů, které hráč vlastní.
 */
class Inventory {
    private List<Item> items = new ArrayList<>();
    /**
     * Přidá předmět do inventáře.
     * @param item předmět k přidání
     */
    public void addItem(Item item) {
        items.add(item);
    }
    /**
     * Odebere předmět z inventáře podle názvu.
     * @param name název předmětu
     */
    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }
    /**
     * Zkontroluje, zda inventář obsahuje předmět daného názvu.
     * @param name název předmětu
     * @return true pokud existuje, jinak false
     */
    public boolean hasItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}

