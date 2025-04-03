class UseCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete použít?");
            return;
        }
        String itemName = args[1];
        if (game.getInventory().hasItem(itemName)) {
            if (itemName.equalsIgnoreCase("Klíč od hlavní cely")) {
                System.out.println("Odemkli jste hlavní celu!");
                game.setUsedKey(true);
            } else if (itemName.equalsIgnoreCase("Lahvička s jedem")) {
                System.out.println("Použili jste jed! Kuchař je mrtvý.");
                game.getInventory().addItem(new Item("peníze"));
            } else if (itemName.equalsIgnoreCase("peníze") && game.getCurrentRoom().name.equalsIgnoreCase("Kancelář vrátného")) {
                System.out.println("Koupili jste klíč k útěku! Jste svobodní!");
                System.exit(0);
            } else {
                System.out.println("Použili jste: " + itemName);
            }
        } else {
            System.out.println("Tento předmět nemáte.");
        }
    }
}

