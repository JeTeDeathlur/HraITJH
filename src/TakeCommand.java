class TakeCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete vzít?");
            return;
        }
        String itemName = args[1];
        Room currentRoom = game.getCurrentRoom();
        Item itemToTake = null;
        for (Item item : currentRoom.items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToTake = item;
                break;
            }
        }
        if (itemToTake != null) {
            game.getInventory().addItem(itemToTake);
            currentRoom.items.remove(itemToTake);
            System.out.println("Sebrali jste: " + itemName);
        } else {
            System.out.println("Tento předmět zde není.");
        }
    }
}