public class SearchCommand implements Command {
    private Player player;
    private String target;

    public SearchCommand(Player player, String target) {
        this.player = player;
        this.target = target;
    }

    @Override
    public void execute() {
        if (target.equalsIgnoreCase("místnost")) {
            System.out.println("Prozkoumáváš místnost: " + player.getCurrentRoom().getName());
            for (Item item : player.getCurrentRoom().getItems()) {
                System.out.println("Našel jsi: " + item.getName() + " - " + item.getDescription());
            }
        } else {
            boolean found = false;
            for (Item item : player.getCurrentRoom().getItems()) {
                if (item.getName().equalsIgnoreCase(target)) {
                    System.out.println("Prozkoumáváš " + target + ". Našel jsi: " + item.getName() + " - " + item.getDescription());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Nemůžeš najít " + target + " v místnosti.");
            }
        }
    }
}
