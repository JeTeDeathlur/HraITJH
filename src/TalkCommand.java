import java.util.List;

public class TalkCommand implements Command {
    private Player player;
    private String characterName;

    public TalkCommand(Player player, String characterName) {
        this.player = player;
        this.characterName = characterName;
    }

    @Override
    public void execute() {
        player.talkToCharacter(characterName);
    }
}
