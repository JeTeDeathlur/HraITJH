class SearchCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        System.out.println("V místnosti se nachází:");
        for (Item item : game.getCurrentRoom().items) {
            System.out.println("- " + item.getName());
        }
        for (Character character : game.getCurrentRoom().characters) {
            System.out.println("- " + character.name);
        }

        if (game.getCurrentRoom().name.equalsIgnoreCase("Temné chodby")) {
            System.out.println("Našli jste skříň. Prohledali jste ji a našli mapu!");
            System.out.println("Mapa: \nHlavní cela -> Temné chodby -> Jídelna -> Kuchyně -> Kancelář vrátného");
        }
    }
}