package pkm.characters;

public class TrainerPokemon extends Pokemon {

    public TrainerPokemon(String name, int type, float life) {
        super(name, type, life, 10);
    }
    
    public void usePotion(int heal) {
        if(getLife() + heal > 100) {
            setLife(100);
        } else {
            setLife(getLife() + heal);
        }
    }
}
