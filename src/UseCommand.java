public class UseCommand implements Command {
    private String itemName;
    private Player player;

    public UseCommand(Player player, String itemName) {
        this.player = player;
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        Item item = player.getInventory().getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (item != null) {
            item.use(player);
        } else {
            System.out.println("Nemáš tento předmět ve svém inventáři.");
        }
    }
}
