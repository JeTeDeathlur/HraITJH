public class GoCommand implements Command {
    private Player player;
    private String direction;

    public GoCommand(Player player, String direction) {
        this.player = player;
        this.direction = direction;
    }

    @Override
    public void execute() {
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom != null) {
            player.moveTo(nextRoom);
        } else {
            System.out.println("Tato místnost neexistuje.");
        }
    }
}
