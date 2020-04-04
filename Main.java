package encryptdecrypt;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String mode = "enc";
        String data = "";
        String in = ""; //using input file is incomplete at this point
        int key = 0;
        String out = ""; //using output file is incomplete at this point
        String alg = "s"; //s for shift, u for unicode

        System.out.print("Enter mode, encrypt (e) or decrypt (d): ");
            mode = sc.nextLine().substring(0,1).toLowerCase();
            switch (mode) {
                case "e":
                    mode = "enc";
                    break;
                case "d":
                    mode = "dec";
                    break;
                default:
                    mode = "enc";
                    System.out.println("Input defaults to encryption.");

            }
        System.out.print("Enter valid key: ");
        if (!sc.hasNextInt()) {
            System.out.println("Integer not valid, key is 0.");
            sc.nextLine();
        } else {
            key = Integer.valueOf(sc.nextLine());
        }



        System.out.print("Enter message: ");
        data = sc.nextLine();
        System.out.print("Enter algorithm, shift (s) or unicode (u)? ");
        alg = sc.nextLine().substring(0,1).toLowerCase();

        Decryptor algMethod = AlgMake.make(alg);

        if (data.equals("") && !in.equals("")) {
            File inFile = new File(in);
            try (Scanner inScan = new Scanner(inFile)) {
                while (inScan.hasNext()) {
                    data = inScan.nextLine();
                }
            } catch (Exception E) {
                System.out.println("File error");
            }
        }

        char[] message = data.toCharArray();

        if (out.equals("")) {
            System.out.println(algMethod.transform(message, key, mode));
        } else {
            try (PrintWriter printWriter = new PrintWriter(out)) {
                printWriter.println(algMethod.transform(message, key, mode));
            } catch (Exception e) {
                System.out.println("error writing to file");
            }
        }

    }
}

