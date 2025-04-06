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
            if (character.getName().equalsIgnoreCase(characterName)) {
                if (character.getName().equals("Strážce")) {
                    System.out.println("Strážce: Běž do jídelny, je čas oběda!");
                } else if (character.getName().equals("Vrátný")) {
                    System.out.println("Vrátný: Chceš klíč k útěku? Můžeš si ho koupit!");
                }
                return;
            }
        }
        System.out.println("Tato postava zde není.");
    }
}
