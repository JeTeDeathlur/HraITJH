import java.util.List;

class TalkCommand extends Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 2) {
            System.out.println("S kým chcete mluvit?");
            return;
        }
        String characterName = args[1];


        for (Character character : game.getCurrentRoom().characters) {
            if (character.name.equalsIgnoreCase(characterName)) {
                System.out.println(character.name + ": ");


                if (characterName.equals("Strážce")) {
                    if (!game.getInventory().hasItem("Klíč od hlavní cely")) {
                        System.out.println("Běž do jídelny, je čas oběda. Musíš však projít přes temné chodby a odemknout tuto celu.");
                    } else {
                        System.out.println("Strážce: Nyní můžeš jít do Temných chodeb, protože máš klíč.");
                    }
                }
                else {
                    System.out.println("Mluvíte s " + character.name);
                }
                return;
            }
        }
        System.out.println("Tato postava zde není.");
    }
}