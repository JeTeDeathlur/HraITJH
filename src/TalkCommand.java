import java.util.List;

class TalkCommand implements Command {
    private Player player;
    private String characterName;

    public TalkCommand(Player player, String characterName) {
        this.player = player;
        this.characterName = characterName;
    }

    @Override
    public void execute() {
        List<Character> characters = player.getCurrentRoom().getCharacters();
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(characterName)) {
                player.talkTo(character);
                return;
            }
        }
        System.out.println("Tato postava není v místnosti.");
    }
}
