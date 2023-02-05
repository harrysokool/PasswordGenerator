package ui;

import model.Password;

import java.util.*;

public class PasswordGenerator {

    // set up
    private Scanner input;          // getting input from user
    private List<String> list;      // list of characters to build the password
    private Random number;          // generate random number
    private int size;               // size of the password
    private int difficulty;         // difficulty of the password (only 1-4)
    private Password pw;                    // the password
    private String[] list1;
    private String[] list2;
    private String[] list3;
    private String[] list4;

    public PasswordGenerator() {
        input = new Scanner(System.in);
        list = new ArrayList<>();
        number = new Random();
        runPasswordGenerator();
    }

    // run the passwordGenerator
    public void runPasswordGenerator() {
        // make arrays of string for different difficulty of the password
        constructLists();

        // selecting the size and difficulty of the password
        System.out.print("Type in the length of the password: ");
        size = input.nextInt();
        System.out.print("Type in the difficulty of the password (level 1-4): ");
        difficulty = input.nextInt();

        pw = new Password(size, difficulty);

        // selecting the difficulty
        passwordDifficulty(difficulty);

        // printing out the password
        pw.showPW();
    }

    // creating arrays of strings for user to choose
    private void constructLists() {
        // arrays of characters
        list1 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}; // difficulty level: 1 (only numbers)
        list2 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"};                      // difficulty level: 2 (numbers, lowercase)
        list3 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};                      // difficulty level: 3 (numbers, upper/lower)
        list4 = new String[]{"!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
                "-", "=", "_", "+", "`", "~", "[", "{", "]", "}",
                "|", ";", ":", "'", "", ",", "<", ".", ">", "/",
                "?"};                                            // difficulty level: 4 (numbers, upper/lower, symbols)
    }

    // selecting which array of string to use according to the difficulty
    private void passwordDifficulty(int difficulty) {
        // for password difficulty level: 1
        if (difficulty == 1) {
            Collections.addAll(list, list1);
            for (int i = 0; i < size; i++) {
                pw.buildPW(list.get(number.nextInt(list.size())));
            }
        }

        // for password difficulty level: 2
        if (difficulty == 2) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            for (int i = 0; i < size; i++) {
                pw.buildPW(list.get(number.nextInt(list.size())));
            }
        }

        // for password difficulty level: 3
        if (difficulty == 3) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            Collections.addAll(list, list3);
            for (int i = 0; i < size; i++) {
                pw.buildPW(list.get(number.nextInt(list.size())));
            }
        }

        // for password difficulty level: 4
        if (difficulty == 4) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            Collections.addAll(list, list3);
            Collections.addAll(list, list4);
            for (int i = 0; i < size; i++) {
                pw.buildPW(list.get(number.nextInt(list.size())));
            }
        }
    }
}
