package model;

// password class
public class Password {
    // Attributes
    String pw;
    int size;
    int difficulty;

    public Password(int size, int difficulty) {
        this.pw = "";
        this.size = size;
        this.difficulty = difficulty;
    }

    public void buildPW(String character) {
        pw += character;
    }

    public void showPW() {
        System.out.println(pw);
    }


}
