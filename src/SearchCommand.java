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
    }
}