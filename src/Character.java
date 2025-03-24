public class Character {
    private String name;
    private String description;

    public Character(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void talk() {
        System.out.println(name + " říká: 'Ahoj, co pro tebe mohu udělat?'");
    }
}

