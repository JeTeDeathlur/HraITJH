public class TakeCommand implements Command {
    private Player player;
    private String itemName;

    public TakeCommand(Player player, String itemName) {
        this.player = player;
        this.itemName = itemName;
    }

    @Override
    public void execute() {
        Item item = null;
        for (Item i : player.getCurrentRoom().getItems()) {
            if (i.getName().equalsIgnoreCase(itemName)) {
                item = i;
                break;
            }
        }
        if (item != null) {
            player.getInventory().addItem(item);
            player.getCurrentRoom().getItems().remove(item);
            System.out.println("Sebral jsi " + itemName);
        } else {
            System.out.println("Tento předmět není v místnosti.");
        }
    }
}
