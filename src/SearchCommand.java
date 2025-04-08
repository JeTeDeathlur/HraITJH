public class SearchCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        Room room = game.getCurrentRoom();
        System.out.println("V místnosti se nachází:");

        for (Item item : room.getItems()) {
            System.out.println("- " + item.getName());
        }

        if (room.getName().equalsIgnoreCase("Temné chodby")) {
            if (!room.hasItem("Mapa")) {
                System.out.println("Našel jsi skříň. V ní je mapa!");
                room.addItem(new Item("Mapa"));
            }
        } else if (room.getName().equalsIgnoreCase("Kuchyně")) {
            if (!room.hasItem("Lahvička s jedem") && !game.hasKilledCook()) {
                System.out.println("Našel jsi lahvičku s jedem!");
                room.addItem(new Item("Lahvička s jedem"));
            } else if (game.hasKilledCook() && room.hasItem("Peněženka")) {
                System.out.println("Našel jsi peněženku, která vypadla kuchaři!");
            }
        } else if (room.getName().equalsIgnoreCase("Jídelna") && game.hasKilledCook()) {
            System.out.println("Pod stolem leží umírající vězeň...");
            System.out.println("Vězeň: Podplať vrátného, jinak se nedostaneš ven!");
        }
          else if (room.getName().equalsIgnoreCase("Sklad")) {
            if (room.hasItem("Dopis od vězňů")) {
                System.out.println("Našel jsi starý, potrhaný dopis. Vypadá to, že ho tu někdo schoval...");
                System.out.println("\"Kuchař nás jednoho po druhém v noci odnášel do kuchyně. Mysleli jsme, že se dostaneme ven... Mýlili jsme se.");
                System.out.println("Žral nás. Zaživa. Nenech ho chytit tě. Uteč. Vyprávěj náš osud světu!\"");
            }
         }

        for (Character character : room.getCharacters()) {
            System.out.println("- " + character.getName() + ": " + character.getDialogue());
        }
    }
}


