//STAUS: Complete

public class Reflector {
    private String reflectorConfig;
    // private String selectedReflector;

    // Reflector Model
    public static final Reflector A = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");
    public static final Reflector B = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
    public static final Reflector C = new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
    // Reflector[] reflectorModel = { A, B, C };

    public Reflector() { }

    //override constructor: set reflector
    //why i have this constructoere wtf
    public Reflector(String reflector) {
        this.reflectorConfig = reflector;
    }

    //reflect the character
    public char reflect(char c) {
        // TODO: implement this
        // Character swap b position if A come in with 65 it will return E in index 0
        // in the same way if E come in with 69 it will return A in index 4
        return reflectorConfig.charAt((int)c - 65);
    }
}
