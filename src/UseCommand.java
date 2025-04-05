class UseCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("Co chcete použít?");
            return;
        }
        String itemName = args[1];
        if (!game.getInventory().hasItem(itemName)) {
            System.out.println("Tento předmět nemáte.");
            return;
        }

        switch (itemName.toLowerCase()) {
            case "klíč":
            case "klíč od hlavní cely":
                System.out.println("Odemkli jste hlavní celu!");
                game.setUsedKey(true);
                break;
            case "jed":
                System.out.println("Otrávil jste kuchaře! Můžete ho teď okrást.");
                game.setKilledCook(true);
                game.getCurrentRoom().addItem(new Item("Peněženka"));
                break;
            default:
                System.out.println("Předmět nelze použít.");
        }
    }
}

