
import java.util.*;
import java.util.*;

public class Player {
    private Room currentRoom;
    private Inventory inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new Inventory();
    }

    public void moveTo(Room room) {
        this.currentRoom = room;
        System.out.println("Přesunul ses do místnosti: " + room.getName());
    }

    public void talkTo(Character character) {
        character.talk();
    }

    public void useItem(String itemName) {
        Item item = inventory.getItem(itemName);
        if (item != null) {
            item.use(this);
        } else {
            System.out.println("Nemáš tento předmět.");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
