package pkm.characters;

import java.util.Random;

import pkm.items.Pokeball;
import pkm.items.Potion;

public class Trainer {
    private String name;
    private TrainerPokemon pokemon;
    private Pokeball pokeball;
    private Potion potion;

    public Trainer(String name, int pokeballs, int potions) {
        this.name = name;
        this.pokeball = new Pokeball(pokeballs);
        this.potion = new Potion(potions);
    }

    public String getName() {
        return name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(TrainerPokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getPotions() {
        return potion.getQnt();
    }

    public int getPokeballs() {
        return pokeball.getQnt();
    }

    public void reward() {
        pokeball.reward();
        potion.reward();
    }

    public String usePotion() {
        if(potion.getQnt() > 0) {
            if(pokemon.getLife() == 100) {
                return "Seu Pokémon já está com a vida cheia!";
            } else {
                potion.use();
                pokemon.usePotion(10);
                return String.format("Poção usada com sucesso!", potion.getQnt());
            }
        } else {
            return "Você não possui poções restantes.";
        }
    }

    public String usePokeball(WildPokemon wild_pkm) {
        Random rand = new Random();
        float chance = 100 / wild_pkm.getLife() * 5;
        if(pokeball.getQnt() > 0) {
            pokeball.use();
            if(rand.nextInt(100) + 1 <= chance) {
                wild_pkm.caught();
                return String.format("Você capturou %s!", wild_pkm.getName().toUpperCase());
            } else {
                wild_pkm.runAway();
                return String.format("Você falhou, %s fugiu.", wild_pkm.getName().toUpperCase());
            }
        } else {
            return "Você não possui pokébolas restantes.";
        }
    }
}
