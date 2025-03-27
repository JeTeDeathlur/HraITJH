

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
            if (player.getCurrentRoom().getName().equals("Hlavní cela")) {
                player.moveTo(player.getCurrentRoom().getExit("Hlavní chodba"));
                System.out.println("Odemkl jsi dveře od hlavní cely a jsi na chodbách. Kam chceš jít teď?");
            } else {
                System.out.println("Tento klíč nepasuje do žádných dveří v této místnosti.");
            }
        } else if (name.equals("Láhev s jedem")) {
            System.out.println("Použil jsi láhev s jedem na stráže.");
        }
    }
}




