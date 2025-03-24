

public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void use(Player player) {
        if (name.equals("Klíč")) {

            System.out.println("Použil jsi klíč k odemknutí místnosti.");

        } else if (name.equals("Láhev s jedem")) {

            System.out.println("Použil jsi láhev s jedem na stráže.");
        }
    }
}



