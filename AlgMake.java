package encryptdecrypt;

public class AlgMake {

    public static Decryptor make(String alg) {
        switch (alg) {
            case "u":
                return new ShiftUnicode();
            case "s":
                return new ShiftAlpha();
            default:
                return null;
        }
    }
}

