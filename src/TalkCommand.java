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
                System.out.println("Mluvíte s " + character.name);
                return;
            }
        }
        System.out.println("Tato postava zde není.");
    }
}