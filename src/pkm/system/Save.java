package pkm.system;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
    
public class Save {
    public static final int NAME = 0;
    public static final int STARTER = 1;
    public static final int POKEBALLS = 2;
    public static final int POTIONS = 3;
    public static final int LIFE = 4;

    // VERIFICA SE EXISTE O ARQUIVO DE SAVE
    public static boolean hasSave() throws IOException {
        Path trainer = Paths.get("save/trainer.txt");
        Path pokedex = Paths.get("save/pokedex.txt");

        if(trainer.toFile().isFile() && pokedex.toFile().isFile()) {
            return true;
        } else {
            return false;
        }
    }

    // CRIA O ARQUIVO DE SAVE
    public static void createSave(String name, int starter) throws IOException {
        String save = String.format("%s;%d;10;10;100", name, starter);

        new File("save").mkdir();
        FileWriter fw = new FileWriter("save/trainer.txt", false);
        new File("save/pokedex.txt").createNewFile();

        fw.append(save);
        fw.close();
    }
 
    // LÊ O ARQUIVO DE SAVE
    public static String readSave(int i) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("save/trainer.txt"));

        String[] element = br.readLine().split(";");
        br.close();

        return element[i];
    }

    // EDITA O ARQUIVO DE SAVE
    public static void editSave(int pokeballs, int potions, float life) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("save/trainer.txt"));
        String[] save = br.readLine().split(";");
        br.close();
        save[POKEBALLS] = Integer.toString(pokeballs);
        save[POTIONS] = Integer.toString(potions);
        save[LIFE] = Float.toString(life);

        BufferedWriter bw = new BufferedWriter(new FileWriter("save/trainer.txt", false));

        for(int i = 0; i < save.length; i++) {
            if(i == 0) {
                bw.append(save[i]);
            } else {
                bw.append(";" + save[i]);
            }
        }
        bw.close();
    }

    // LÊ O ARQUIVO DA POKÉDEX
    public static String[] readPokedex() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("save/pokedex.txt"));
        String[] error = {"Você ainda não capturou nenhum Pokémon."};
        try {
            String[] pokedex = br.readLine().split(";");
            br.close();
            return pokedex;
        } catch (Exception e) {
            br.close();
            return error;
        }
    }

    // ADICIONA UM POKÉMON NA POKÉDEX
    public static void addToPokedex(String str) throws IOException {
        FileWriter fw = new FileWriter("save/pokedex.txt", true);
        BufferedReader br = new BufferedReader(new FileReader("save/pokedex.txt"));

        if(br.readLine() == null) {
            fw.append(str);
        } else {
            fw.append(";" + str);
        }
        br.close();
        fw.close();
    }

    // EXCLUI O ARQUIVO DE SAVE
    public static void delSave() {
        new File("save/trainer.txt").delete();
        new File("save/pokedex.txt").delete();
        new File("save").delete();
    }
}