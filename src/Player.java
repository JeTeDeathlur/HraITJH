import java.util.*;

public class Player {
    private Room currentRoom;
    private Inventory inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new Inventory();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void moveTo(Room room) {
        if (room != null) {
            currentRoom = room;
            System.out.println("Přesouváš se do místnosti: " + room.getName());
        } else {
            System.out.println("Tato místnost neexistuje.");
        }
    }

    public void takeItem(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("Sebral jsi: " + item.getName());
        } else {
            System.out.println("Tento předmět není v místnosti.");
        }
    }

    public void talkToCharacter(String characterName) {
        List<Character> characters = currentRoom.getCharacters();
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(characterName)) {
                if (character.getName().equalsIgnoreCase("Strážce")) {
                    System.out.println("Strážce: Jídlo už je hotové, mazej do jídelny!");
                } else {
                    System.out.println("Mluvíš s " + character.getName() + ": " + character.getDescription());
                }
                return;
            }
        }
        System.out.println("Tato postava není v místnosti.");
    }
}



