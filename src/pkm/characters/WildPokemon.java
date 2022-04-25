package pkm.characters;

public class WildPokemon extends Pokemon {
    private boolean caught = false;

    public WildPokemon(String name, int type) {
        super(name, type, 20, 5);
    }

    public boolean isCaught() {
        return caught;
    }

    public void caught() {
        caught = true;
    }
}