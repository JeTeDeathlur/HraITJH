/**
 * Příkaz pro komunikaci s postavou.
 */
class TalkCommand extends Command {
    /**
     * Spustí komunikaci s postavou.
     * @param game instance hry
     * @param paremeters název příkazu a jméno postavy
     */
    @Override
    public void execute(Game game, String[] paremeters) {
        if (paremeters.length < 2) {
            System.out.println("S kým chcete mluvit?");
            return;
        }

        String characterName = paremeters[1];
        for (Character character : game.getCurrentRoom().getCharacters()) {
            if (character.getName().equalsIgnoreCase(characterName)) {
                if (character.getName().equals("Strážce")) {
                    System.out.println("Strážce: Běž do jídelny, je čas oběda!");
                } else if (character.getName().equals("Vrátný")) {
                    System.out.println("Vrátný: Chceš klíč k útěku? Můžeš si ho koupit!");
                } else if (character.getName().equals("Kuchař")) {
                    if (!game.hasKilledCook()) {
                        System.out.println("Promluvil jsi s kuchařem! Odhalil tě a zavolal stráže. Hra skončila.");
                        System.exit(0);
                    } else {
                        System.out.println("Kuchař je mrtvý. Neodpovídá...");
                    }
                }
                return;
            }
        }

        System.out.println("Tato postava zde není.");
    }
}
