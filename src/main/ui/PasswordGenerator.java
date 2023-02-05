package ui;

import model.Password;

import java.util.*;

public class PasswordGenerator {

    // set up
    private final Scanner input;          // getting input from user
    private final List<String> list;      // list of characters to build the password
    private final Random number;          // generate random number
    private int size = 0;               // size of the password
    private int difficulty = 0;
    private Password pw;            // the password
    private String[] list1;         // lists with numbers only
    private String[] list2;         // numbers and lowercase
    private String[] list3;         // numbers, lowercase, uppercase
    private String[] list4;         // numbers, lowercase, uppercase and symbols
    private boolean run;

    public PasswordGenerator() {
        input = new Scanner(System.in);
        list = new ArrayList<>();
        number = new Random();
        runPasswordGenerator();
    }

    // run the passwordGenerator
    public void runPasswordGenerator() {
        System.out.println("Welcome to Password Generator.");
        run = true;
        while (run) {

            // initialize
            pw = new Password();
            size = 0;
            difficulty = 0;

            // make arrays of string for different difficulty of the password
            constructLists();

            // getting info for the password from user
            getSizeOfPassword();
            getDifficultyOfPassword();

            // selecting the difficulty
            passwordDifficulty(difficulty);

            // printing out the password
            pw.showPW();

            // quit or continue
            quitOrContinue();

        }
    }

    // helper methods

    // get size of the password from user
    private void getSizeOfPassword() {
        while (size < 1) {
            try {
                // selecting the size and difficulty of the password
                System.out.print("Type in the length of the password: ");
                size = input.nextInt();
                if (size < 1) {
                    throw new Exception();
                }
            } catch (Exception exception) {
                System.out.println("Size cannot be less than or equals to 0!!!");
            }
        }
    }

    // get difficulty of password
    private void getDifficultyOfPassword() {
        while (difficulty < 1 || difficulty > 4) {
            try {
                // difficulty of the password (only 1-4)
                System.out.print("Type in the difficulty of the password (level 1-4): ");
                difficulty = input.nextInt();
                if (difficulty < 1 || difficulty > 4) {
                    throw new Exception();
                }
                pw = new Password(size, difficulty);
            } catch (Exception exception) {
                System.out.println("Difficulty is out of range!!!");
            }
        }
    }

    // creating arrays of strings for user to choose
    private void constructLists() {
        // arrays of characters
        list1 = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}; // difficulty level: 1
        list2 = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"};                      // difficulty level: 2
        list3 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};                      // difficulty level: 3
        list4 = new String[]{"!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
                "-", "=", "_", "+", "`", "~", "[", "{", "]", "}",
                "|", ";", ":", "'", "", ",", "<", ".", ">", "/",
                "?"};                                            // difficulty level: 4
    }

    // selecting which array of string to use according to the difficulty
    private void passwordDifficulty(int difficulty) {
        // for password difficulty level: 1
        if (difficulty == 1) {
            Collections.addAll(list, list1);
            for (int i = 0; i < size; i++)
                pw.buildPW(list.get(number.nextInt(list.size())));
        }

        // for password difficulty level: 2
        if (difficulty == 2) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            for (int i = 0; i < size; i++)
                pw.buildPW(list.get(number.nextInt(list.size())));
        }

        // for password difficulty level: 3
        if (difficulty == 3) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            Collections.addAll(list, list3);
            for (int i = 0; i < size; i++)
                pw.buildPW(list.get(number.nextInt(list.size())));
        }

        // for password difficulty level: 4
        if (difficulty == 4) {
            Collections.addAll(list, list1);
            Collections.addAll(list, list2);
            Collections.addAll(list, list3);
            Collections.addAll(list, list4);
            for (int i = 0; i < size; i++)
                pw.buildPW(list.get(number.nextInt(list.size())));
        }
    }

    private void quitOrContinue() {
        System.out.println("Enter q to quit.");
        System.out.println("Enter anything for generating new password.");
        String quit = input.next();

        if (quit.equals("q")) {
            run = false;
            System.out.println("Thank you for using the password generator.");
        }
    }
}
