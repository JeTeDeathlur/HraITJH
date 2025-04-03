class UseCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete použít?");
            return;
        }
        String itemName = args[1];
        if (game.getInventory().hasItem(itemName)) {
            System.out.println("Použili jste: " + itemName);
        } else {
            System.out.println("Tento předmět nemáte.");
        }
    }
}


