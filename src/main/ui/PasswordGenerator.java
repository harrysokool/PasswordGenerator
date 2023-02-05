package ui;

import model.Password;

import java.util.*;

public class PasswordGenerator {

    // set up
    private Scanner sc = new Scanner(System.in);
    private List<String> list = new ArrayList<>();
    private Random number = new Random();

    public void runPasswordGenerator() {
        // arrays of characters
        String[] list1 = {"1", "2", "3", "4", "5" , "6", "7", "8", "9", "0"}; // difficulty level: 1
        String[] list2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"};                      // difficulty level: 2
        String[] list3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};                      // difficulty level: 3
        String[] list4 = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
                "-", "=", "_", "+", "`", "~", "[", "{", "]", "}",
                "|", ";", ":", "'", "", ",", "<", ".", ">", "/",
                "?"};                                               // difficulty level: 4

        // selecting the size and difficulty of the password
        System.out.print("Type in the size of the password: ");
        int size = sc.nextInt();
        System.out.print("Type in the difficulty of the password (level 1-4): ");
        int difficulty = sc.nextInt();

        Password pw = new Password(size, difficulty);

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

        // printing out the password
        pw.showPW();
    }
}
