/**
 * Abstraktní třída pro herní příkazy.
 */
abstract class Command {
    /**
     * Provede daný příkaz ve hře.
     * @param game instance hry
     * @param parameters parametry příkazu
     */
    public abstract void execute(Game game, String[] parameters);
}

