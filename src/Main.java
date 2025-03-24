
public class Main {
    public static void main(String[] args) {
        Room mainCell = new Room("Hlavní cela", "Jsi v hlavní cele vězení. Všude je tma a zatuchlý vzduch.");
        Room darkCorridor = new Room("Temné chodby", "Úzká chodba vedoucí k několika různým místnostem. Je tu tma a slyšíš kroky stráží.");
        Room kitchen = new Room("Kuchyně", "Kuchyně je plná zápachu. Vaří se tu jídlo pro vězně a stráže.");
        Room toolRoom = new Room("Místnost s nástroji", "Staré nástroje a předměty, které by ti mohly pomoci při útěku.");
        Character guard = new Character("Strážce", "Strážce vězení, který patroluje chodby.");
        Character cook = new Character("Kuchař", "Bláznivý kuchař, který je neustále podrážděný.");
        mainCell.addCharacter(guard);
        kitchen.addCharacter(cook);


        Item key = new Item("Klíč", "Klíč, který otevírá zámek v hlavní cele.");
        Item map = new Item("Mapa", "Mapa vězení, která ukazuje tajné chodby.");


        mainCell.addItem(key);
        kitchen.addItem(map);


        mainCell.addExit("jdi temné chodby", darkCorridor);
        darkCorridor.addExit("jdi hlavní cela", mainCell);
        darkCorridor.addExit("jdi kuchyně", kitchen);
        kitchen.addExit("jdi místnost s nástroji", toolRoom);
        Player player = new Player(mainCell);



        Game game = new Game(player);
        game.start();
    }
}
