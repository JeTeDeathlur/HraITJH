class TakeCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete vzít?");
            return;
        }
        String itemName = args[1];
        Room room = game.getCurrentRoom();
        Item item = room.getItem(itemName);
        if (item != null) {
            game.getInventory().addItem(item);
            room.removeItem(item);
            System.out.println("Sebrali jste: " + itemName);
            if (itemName.equalsIgnoreCase("Peněženka")) {
                game.setHasMoney(true);
            }
        } else {
            System.out.println("Tento předmět zde není.");
        }
    }
}