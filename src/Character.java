/**
 * Reprezentuje postavu ve hře.
 */
class Character {
    private String name;
    private String dialogue;
    /**
     * Vytvoří novou postavu se jménem a dialogem.
     * @param name jméno postavy
     * @param dialogue dialog postavy
     */

    public Character(String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }
    /**
     * Vrátí jméno postavy.
     * @return jméno
     */
    public String getName() {
        return name;
    }
    /**
     * Vrátí dialog postavy.
     * @return dialog
     */
    public String getDialogue() {
        return dialogue;
    }
}

