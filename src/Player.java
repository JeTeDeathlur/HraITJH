
import java.util.*;

public class Player {
    private Inventory inventory;
    private Room currentRoom;


    public Player(Room startingRoom) {
        this.inventory = new Inventory();
        this.currentRoom = startingRoom;
    }
    public void takeItem(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("Sebral jsi předmět: " + item.getName());
        } else {
            System.out.println("Tento předmět zde není.");
        }
    }

    public void useItem(String itemName) {
        Item item = inventory.getItem(itemName);
        if (item != null) {
            item.use(this);
            System.out.println("Použil jsi: " + item.getName());
        } else {
            System.out.println("Nemáš tento předmět ve svém inventáři.");
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void moveTo(Room room) {
        this.currentRoom = room;
    }


    public void talkToCharacter(String characterName) {
        for (Character character : currentRoom.getCharacters()) {
            if (character.getName().equalsIgnoreCase(characterName)) {

                character.talk();
                return;
            }
        }
        System.out.println("Postava " + characterName + " není v této místnosti.");
    }
    public void talkTo(Character character) {
        character.talk();
    }


    public void searchItem(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Našel jsi: " + item.getName() + " - " + item.getDescription());
                return;
            }
        }
        System.out.println("Nemůžeš najít " + itemName + " v místnosti.");
    }
}
