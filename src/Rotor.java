//STAUS: Complete. Maybe?

public class Rotor {
    //<<---------- S E T T I N G S ---------->>
    // Output for roters
    private String forwardOut;
    private String revOut;
    // Reverse output for roters

    // Main structure of rotor
    // private String wiring;
    // turnover notch
    private String notch;
    // end section 

    public static final Rotor I = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "R");
    public static final Rotor II = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "F");
    public static final Rotor III = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "W");
    public static final Rotor IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", "K");
    public static final Rotor V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", "A");

    public static final Rotor VI = new Rotor("JPGVOUMFYQBENHZRDKASXLICTW", "AN");
    public static final Rotor VII = new Rotor("NZJHGRCXMYSWBOUFAIVLPEKQDT", "AN");
    public static final Rotor VIII = new Rotor("FKQHTLXOCBJSPDZRAMEWNIUYGV", "AN");

    // Constructor
    public Rotor(String wiring, String notch) {
        this.forwardOut = wiring;
        this.notch = notch;
        char[] revList = new char[26];
        for (int i = 0; i < wiring.length(); i++) {
            revList[(int) wiring.charAt(i) - 65] = (char) (i + 65);
        }
        //reverse the rotor, using after reflector
        String ro = "";
        for (char c : revList)
            ro += String.valueOf(c);
        revOut = ro;
    }

    // Useful for the Enigma class, offsets a char in a circular fashion by a
    // specified amount. i.e. offset('A', 2) = 'C' and offset('Z', 3) = 'C'
    public static char offset(char start, int shift) {
        if (shift > 0) {
            if ((start + shift) > 90)
                return (char) (65 + shift - (90 - start) - 1);
            else
                return (char) (start + shift);
        } else {
            if ((start + shift) < 65)
                return (char) (90 + (shift + (start - 65)) + 1);
            else
                return (char) (start + shift);
        }
    }

    // <<---------- U T I L I T Y ---------->>
    public String getNotches() {
        return notch;
    }

    public String getforwardOut() {
        return forwardOut;
    }

    public boolean isNotch(char c) {
        // check matchinh notch(es) if there multiple notches
        for (int i = 0; i < notch.length(); i++) {
            if (notch.charAt(i) == c)
                return true;
        }
        return false;
    }
    
    // change ring setting to sth else
    public char output(char in, int ringSetting) {
        // to avoid overflow of characters
        char alphChar = offset(in, -(ringSetting - 1));
        int offset = forwardOut.charAt((int) (alphChar) - 65) - alphChar;
        return offset(in, offset);
    }

    // Same as above, but for traversing in reverse direction
    // change ring setting to sth else
    public char revOutput(char in, int ringSetting) {
        // to avoid overflow of characters
        char alphChar = offset(in, -(ringSetting - 1));
        int offset = revOut.charAt((int) (alphChar) - 65) - alphChar;
        return offset(in, offset);
    }
}
