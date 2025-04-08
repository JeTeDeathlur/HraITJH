/**
 * Reprezentuje položku v inventáři nebo místnosti.
 */
class Item {
    private String name;
    /**
     * Vytvoří novou položku se zadaným názvem.
     * @param name název položky
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Vrátí název položky.
     * @return název
     */
    public String getName() {
        return name;
    }
}

