import java.io.*;
import java.util.*;

class GameWorld {
    private Map<String, List<String>> rooms = new HashMap<>();
    private String currentRoom;

    public GameWorld(String mapFile) throws IOException {
        loadMap(mapFile);
        currentRoom = "Hlavní chodba";
    }

    private void loadMap(String mapFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(mapFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                rooms.put(parts[0], Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length)));

            }
        }
    }

    public void move(String direction) {
        if (rooms.get(currentRoom).contains(direction)) {
            currentRoom = direction;
            System.out.println("Přesunul ses do: " + currentRoom);
        } else {
            System.out.println("Tímto směrem se nelze pohnout!");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vítej v únikové hře! Pohybuj se mezi místnostmi.");
        while (true) {
            System.out.println("Jsi v místnosti: " + currentRoom);
            System.out.print("Kam chceš jít? ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            move(command);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("mapa.csv"))) {
            writer.println("Hlavní chodba,Cela 1,Cela 2,Jídelna,Sklad");
            writer.println("Cela 1,Hlavní chodba");
            writer.println("Cela 2,Hlavní chodba");
            writer.println("Jídelna,Hlavní chodba,Kuchyně");
            writer.println("Kuchyně,Jídelna");
            writer.println("Sklad,Hlavní chodba");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            GameWorld world = new GameWorld("mapa.csv");
            world.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

