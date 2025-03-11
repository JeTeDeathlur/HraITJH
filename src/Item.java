public abstract class Item {
    protected String name;
    protected String description;

    public abstract void use(Player player);
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}