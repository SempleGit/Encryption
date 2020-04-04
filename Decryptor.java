package encryptdecrypt;

public abstract class Decryptor {
    public abstract String transform (char[] message, int key, String mode);
}
