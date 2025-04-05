class SearchCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        Room room = game.getCurrentRoom();
        System.out.println("V místnosti se nachází:");
        for (Item item : room.getItems()) {
            System.out.println("- " + item.getName());
        }
        if (room.getName().equalsIgnoreCase("Temné chodby")) {
            System.out.println("Našel jsi skříň. V ní je mapa!");
            room.addItem(new Item("Mapa"));
        } else if (room.getName().equalsIgnoreCase("Kuchyně")) {
            System.out.println("Našel jsi lahvičku s jedem!");
            room.addItem(new Item("Jed"));
        } else if (room.getName().equalsIgnoreCase("Jídelna") && game.hasKilledCook()) {
            System.out.println("Pod stolem leží umírající vězeň...");
            System.out.println("Vězeň: Podplať vrátného, jinak se nedostaneš ven!");
        }
    }
}