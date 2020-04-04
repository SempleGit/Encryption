package encryptdecrypt;

public class ShiftAlpha extends Decryptor{
    public String transform (char[] message, int key, String mode) {
        String outMessage = "";
        char beginFirst = 'A';
        char endFirst = 'Z';
        char beginSecond = 'a';
        char endSecond = 'z';
        int rangeSize = endFirst - beginFirst + 1;

        int shift;
        if ("dec".equals(mode)){
            key = rangeSize-key;
        }

        for (char i : message) {
            if (i >= beginFirst && i <= endFirst) {
                shift = (i - beginFirst + key) % rangeSize + beginFirst;
                outMessage += Character.toString(shift);
            } else if (i >= beginSecond && i <= endSecond) {
                shift = (i - beginSecond + key) % rangeSize + beginSecond;
                outMessage += Character.toString(shift);
            } else outMessage += Character.toString(i);
        }

        return outMessage;
    }
}
