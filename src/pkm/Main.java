package pkm;

import pkm.characters.Trainer;
import pkm.characters.Pokemon;
import pkm.characters.TrainerPokemon;
import pkm.characters.WildPokemon;
import pkm.system.Save;

import static pkm.system.Util.*;
import static pkm.system.Save.*;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        while(true) {
            // TELA INICIAL
            startScreen();
            pause();

            // CRIA O SAVE SE NÃO EXISTIR
            if(!hasSave()) {
                // INSIRA SEU NOME
                menu("Insira seu nome:");
                String name = readStr();

                // TUTORIAL
                menu("Escolha um companheiro para sua jornada... ");
                pause();
                menu("Mas escolha com sabedoria! ");
                pause();
                menu("Pois ele batalhará ao seu lado até o fim...");
                pause();

                // ESCOLHA SEU POKÉMON INICIAL
                starterScreen();
                int op = readOp(1, 3);

                // TUTORIAL
                menu("Sua jornada irá começar em breve...");
                pause();
                menu("Você recebeu 10 Pokébolas e 10 Poções para começar!");
                pause();
                menu("Ao derrotar um Pokémon você recebe 1 Pokébola e 1 Poção...");
                pause();
                menu("Mas perde a chance de capturá-lo...");
                pause();
                menu("Seu objetivo é capturar o máximo de Pokémons que conseguir.");
                pause();
                menu("Gotta Catch ’Em All!");
                pause();

                createSave(name, op);
            }

            // CARREGA O SAVE
            if(hasSave()) {
                Trainer trainer;
                TrainerPokemon trainer_pkm;
                WildPokemon wild_pkm;
                
                // CARREGA O TRAINER
                trainer = new Trainer(readSave(Save.NAME), Integer.parseInt(readSave(Save.POKEBALLS)), Integer.parseInt(readSave(Save.POTIONS)));

                // CARREGA O POKÉMON DO TRAINER
                switch(Integer.parseInt(readSave(Save.STARTER))) {
                    case Pokemon.GRASS:
                        trainer_pkm = new TrainerPokemon("Bulbasaur", Pokemon.GRASS, Float.parseFloat(readSave(Save.LIFE)));
                        break;
                    case Pokemon.WATER:
                        trainer_pkm = new TrainerPokemon("Squirtle", Pokemon.WATER, Float.parseFloat(readSave(Save.LIFE)));
                        break;
                    case Pokemon.FIRE:
                        trainer_pkm = new TrainerPokemon("Charmander", Pokemon.FIRE, Float.parseFloat(readSave(Save.LIFE)));
                        break;
                    default:
                        trainer_pkm = new TrainerPokemon("Pikachu", -1, Float.parseFloat(readSave(Save.LIFE)));
                        break;
                }
                trainer.setPokemon(trainer_pkm);

                // GAMEPLAY
                while(hasSave()) {
                    // MENU
                    menu("1 - Procurar Pokémons     2 - Ver Pokédex     3 - Excluir Save");
    
                    switch(readOp(1, 3)) {
                        // BATALHA DE POKÉMONS
                        case 1:
                            // GERA UM POKÉMON SELVAGEM
                            String[][] wild_pokemons = {{"Tangela", "Gloom", "Bellsprout" }, {"Tentacool", "Poliwag", "Psyduck"}, {"Ponyta", "Growlith", "Vulpix"}};
                            Random rand = new Random();
                            int x = rand.nextInt(3);
                            int y = rand.nextInt(3);
                            wild_pkm = new WildPokemon(wild_pokemons[x][y], x + 1);
                            menu(wild_pkm.getName().toUpperCase() + " selvagem apareceu!");
                            pause();
    
                            // LOOP DA BATALHA
                            boolean loopBreaker = true;
                            while(loopBreaker) {
                                battleScreen(trainer_pkm.getName(), wild_pkm.getName(), trainer_pkm.getLife(), wild_pkm.getLife(), trainer.getPokeballs(), trainer.getPotions());
                                switch(readOp(1, 4)) {
                                    // ATACAR
                                    case 1:
                                        trainer_pkm.attack(wild_pkm);
                                        // GANHOU A BATALHA
                                        if(!wild_pkm.isAlive()) {
                                            trainer.reward();
                                            menu(String.format("Você venceu a batalha contra %s", wild_pkm.getName().toUpperCase()));
                                            pause();
                                            menu("Como recompensa você recebeu 1 Pokébola e 1 Poção!");
                                            pause();
                                            loopBreaker = false;
                                            break;
                                        }
                                        wild_pkm.attack(trainer_pkm);
                                        // PERDEU A BATALHA
                                        if(!trainer_pkm.isAlive()) {
                                            menu("Você e seu Pokémon foram derrotados.");
                                            pause();
                                            menu(String.format("Total de %d Pokémons capturados.", readPokedex().length));
                                            pause();
                                            delSave();
                                            loopBreaker = false;
                                            break;
                                        }
                                        break;
                                    // FUGIR
                                    case 2:
                                        trainer_pkm.ranAway();
                                        menu("Você fugiu da batalha.");
                                        pause();
                                        loopBreaker = false;
                                        break;
                                    // USA POKÉBOLA 
                                    case 3:
                                        menu(trainer.usePokeball(wild_pkm));
                                        pause();
                                        if(wild_pkm.isCaught()) {
                                            addToPokedex(wild_pkm.getName());
                                            loopBreaker = false;
                                        } else if(wild_pkm.ranAway()) {
                                            loopBreaker = false;
                                        }
                                        break;
                                    // USA POÇÃO
                                    case 4:
                                        menu(trainer.usePotion());
                                        pause();
                                        break;
                                }
                                if(hasSave()) {
                                    editSave(trainer.getPokeballs(), trainer.getPotions(), trainer_pkm.getLife());
                                }
                            }
                            break;
                        // IMPRIME A POKÉDEX
                        case 2:
                            printPokedex(readPokedex());
                            pause();
                            break;
                        // APAGA O SAVE
                        case 3:
                            menu("Tem certeza que deseja apagar todo o seu progresso?");
                            menu("1 - Sim          2 - Não");
                            switch (readOp(1, 2)) {
                                case 1:
                                    delSave();
                                    break;
                                case 2:
                                    break;
                            }
                    }
                }
            }
        }
    }
}
