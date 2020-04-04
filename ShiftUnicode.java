package encryptdecrypt;

public class ShiftUnicode extends Decryptor {
    public String transform(char[] message, int key, String mode){
        String outMessage = "";

        if ("dec".equals(mode)){
            key *= -1;
        }

        for (char i : message) {
            outMessage += Character.toString(i + key);
        }

        return outMessage;
    }
}
