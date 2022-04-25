package pkm.system;

import java.util.Scanner;

public class Util {
    private static final Scanner in = new Scanner(System.in);

    public static void pause() { 
            System.out.println("Aperte <ENTER> para continuar...");
            in.nextLine();
    }

    public static String readStr() {
        String str = "";
        while(str.length() == 0 || str.contains(";")) {
            str = in.nextLine();
        }
        System.out.println();
        return str;
    }

    public static int readOp(int x, int y) {
        int op = -1;
        do {
            try {
                op = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                continue;
            }
        } while (op < x || op > y);
        System.out.println();
        return op;
    }

    static String centerText(String str, int size) {
        int left = (size - str.length()) / 2;
        int right = size - left - str.length();
        String text = "";
        for(int i = 0; i < left; i++) {
            text += " ";
        }
        text += str;
        for(int i = 0; i < right; i++) {
            text += " ";
        }
        return text;
    }

    static String printLife(int max, float life) {
        String text = "";
        for(int i = 0; i < max; i++) {
            if(i < life / 10) {
                text += "█";
            } else {
                text += " ";
            }
        }
        return text;
    }

    public static void startScreen() {
        System.out.println("+==================================================================================+");
        System.out.println("|                                         ,'\\                                      |");
        System.out.println("|           _.----.        ____         ,'  _\\   ___    ___     ____               |");
        System.out.println("|       _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.         |");
        System.out.println("|       \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |        |");
        System.out.println("|        \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |        |");
        System.out.println("|          \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |        |");
        System.out.println("|           \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |        |");
        System.out.println("|            \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |        |");
        System.out.println("|             \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |        |");
        System.out.println("|              \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |        |");
        System.out.println("|               \\_.-'       |__|    `-._ |              '-.|     '-.| |   |        |");
        System.out.println("|                                       `'                            '-._|        |");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|               __                              _ _ _   _                          |");
        System.out.println("|               \\ \\  __ ___   ____ _    ___  __| (_) |_(_) ___  _ __  ©            |");
        System.out.println("|                \\ \\/ _` \\ \\ / / _` |  / _ \\/ _` | | __| |/ _ \\| '_ \\              |");
        System.out.println("|             /\\_/ / (_| |\\ V / (_| | |  __/ (_| | | |_| | (_) | | | |             |");
        System.out.println("|             \\___/ \\__,_| \\_/ \\__,_|  \\___|\\__,_|_|\\__|_|\\___/|_| |_|             |");
        System.out.println("|==================================================================================+");
        System.out.println("V");
    }

    public static void starterScreen() {
        System.out.println("+==================================================================================+");
        System.out.println("|       ▄▄▄██████▄▄▄                ▄▄▄██████▄▄▄                ▄▄▄██████▄▄▄       |");
        System.out.println("|      █▓▓▓▓▓▓▓▓▓▓▓▓█              █▓▓▓▓▓▓▓▓▓▓▓▓█              █▓▓▓▓▓▓▓▓▓▓▓▓█      |");
        System.out.println("|    █▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█          █▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█          █▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█    |");
        System.out.println("|   █▓▓▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓█        █▓▓▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓█        █▓▓▓▓▓▓▓▓░░▓▓▓▓▓▓▓▓█   |");
        System.out.println("|   ████████░██░████████        ████████░██░████████        ████████░██░████████   |");
        System.out.println("|   █░░░░░░░░▓▓░░░░░░░░█        █░░░░░░░░▓▓░░░░░░░░█        █░░░░░░░░▓▓░░░░░░░░█   |");
        System.out.println("|    █░░░░░░░░░░░░░░░░█          █░░░░░░░░░░░░░░░░█          █░░░░░░░░░░░░░░░░█    |");
        System.out.println("|     ▀█░░░░░░░░░░░░█▀            ▀█░░░░░░░░░░░░█▀            ▀█░░░░░░░░░░░░█▀     |");
        System.out.println("|       ▀▀▀██████▀▀▀                ▀▀▀██████▀▀▀                ▀▀▀██████▀▀▀       |");
        System.out.println("+==================================================================================+");
        System.out.println("|                                                                                  |");
        System.out.println("|      1 - Bulbasaur                2 - Squirtle               3 - Charmander      |");
        System.out.println("|                                                                                  |");
        System.out.println("|==================================================================================+");
        System.out.println("V");
    }

    public static void battleScreen(String trainer_pkm, String wild_pkm, float trainer_life, float wild_life, int pokeballs, int potions) {
        System.out.println("|==================================================================================+");
        System.out.println("|                                                                                  |");
        System.out.printf("|          %s                                                         |%n", centerText("Wild " + wild_pkm, 15));
        System.out.println("|                                                                                  |");
        System.out.printf("|              [%s]                                                                |%n", printLife(2, wild_life));
        System.out.printf("|                                                              %s          |%n", centerText(trainer_pkm, 10));
        System.out.println("|                                                                                  |");
        System.out.printf("|                                                             [%s]         |%n", printLife(10, trainer_life));
        System.out.println("|                                                                                  |");
        System.out.println("|==================================================================================+");
        System.out.println("|                                                                                  |");
        System.out.printf("|%s|%n", centerText(String.format("1 - Atacar     2 - Fugir     3 - Pokébola[%d]    4 - Poção[%d]", pokeballs, potions), 82));
        System.out.println("|                                                                                  |");
        System.out.println("|==================================================================================+");
        System.out.println("V");
    }

    public static void menu(String str) {
        System.out.println("+==================================================================================+");
        System.out.println("|                                                                                  |");
        System.out.printf("|%s|%n", centerText(str, 82));
        System.out.println("|                                                                                  |");
        System.out.println("|==================================================================================+");
        System.out.println("V");
    }

    public static void printPokedex(String[] str) {
        System.out.println("+==================================================================================+");
        System.out.printf("|%s|%n", centerText(String.format("SUA POKÉDEX [%d]", str.length), 82));
        System.out.println("|----------------------------------------------------------------------------------|");
        for(int i = 0; i < str.length; i++) {
            System.out.printf("|%s|%n", centerText(str[i], 82));
        }
        System.out.println("|==================================================================================+");
        System.out.println("V");
    }
}
