//Status: Complete

public class Plugboard {
    //the plugboard
    private char[] plugboard = new char[26];

    //constructor -> initialize the plugboard basics
    public Plugboard() {
        for (int i = 0; i < 26; i++) {
            plugboard[i] = (char) (i + 65);
        }
    }

    //plug two letters together, aka. swap the position of two letter of plugboard
    public void connect(char c1, char c2) {
        plugboard[(int)c1 - 65] = c2;
        plugboard[(int)c2 - 65] = c1;
    }

    //get character from plugboard
    public char get(char c) {
        return plugboard[(int)c - 65];
    }
}
