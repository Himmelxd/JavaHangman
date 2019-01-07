//Felix Beichler
package de.himmelxd.hangman;

import java.util.LinkedList;

public class Graphics {

    public static void drawManWin() {
        System.out.println("");
        System.out.println("    U");
        System.out.println("   _|_");
        System.out.println("");
        System.out.println("   \\O/");
        System.out.println("    |");
        System.out.println("   / \\");
    }

    public static void drawHang(int chancesLeft) {
        switch (chancesLeft) {
        case 7:
            System.out.println("");
            System.out.println("                |/");
            System.out.println("");
            System.out.println("           [7]");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            break;

        case 6:
            System.out.println("");
            System.out.println("                |_");
            System.out.println("");
            System.out.println("           [6]");
            System.out.println("");
            System.out.println("");
            System.out.println(" __________");
            break;

        case 5:
            System.out.println("");
            System.out.println("|               |");
            System.out.println("|                \\");
            System.out.println("|          [5]");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
            break;

        case 4:
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("|/              |");
            System.out.println("|               |");
            System.out.println("|          [4]");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
            break;

        case 3:
            System.out.println(" _______");
            System.out.println("|/              |");
            System.out.println("|              /");
            System.out.println("|          [3]");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
            break;

        case 2:
            System.out.println(" _______");
            System.out.println("|/     |       _|");
            System.out.println("|");
            System.out.println("|          [2]");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
            break;

        case 1:
            System.out.println(" _______");
            System.out.println("|/     |       \\|");
            System.out.println("|      O");
            System.out.println("|      |   [1]");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
            break;

        case 0:
            System.out.println(" _______");
            System.out.println("|/     |       |");
            System.out.println("|      O");
            System.out.println("|     /|\\  [0]");
            System.out.println("|     / \\");
            System.out.println("|           You died  x_x");
            System.out.println("|__________");
            break;

        default:
            System.out.println("");
            System.out.println("                |/");
            System.out.println("");
            System.out.println("           [" + (chancesLeft) + "]");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            break;
        }
    }

    public static String wordCurrently(LinkedList<Character> charsToRemaining, String wordToHide) {
        String out = "";
        for (int i = 0; wordToHide.length() > i; i++) {
            if (charsToRemaining.contains(Character.toLowerCase(wordToHide.charAt(i)))) {
                out += "_ ";
            } else {
                out += wordToHide.charAt(i) + " ";
            }
        }
        return out;
    }

    public static void clear(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("");
        }
    }

}