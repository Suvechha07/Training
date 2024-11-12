/*Write a program in java to convert the first ‘n’ decimal numbers of a disc
file to binary using recursion. Store the binary value in a separate disc file.*/
import java.io.*;
import java.util.*;

public class recursion_2 {

    public static String decimalToBinary(int num) {
        if (num == 0) {
            return "0";
        }
        return decimalToBinary(num / 2) + (num % 2);
    }

    public static String padBinaryString(String binary) {
        return String.format("%16s", binary).replace(' ', '0');
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DecimalToBinary <n> <File file> <File file>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        String sourceFile = args[1];
        String destinationFile = args[2];

        try {
            Scanner scanner = new Scanner(new File(sourceFile));
            List<Integer> decimalNumbers = new ArrayList<>();
            for (int i = 0; i < n && scanner.hasNextInt(); i++) {
                decimalNumbers.add(scanner.nextInt());
            }
            scanner.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));

            for (int decimal : decimalNumbers) {
                String binary = decimalToBinary(decimal);
                binary = padBinaryString(binary);
                writer.write("The binary equivalent of " + decimal + " is " + binary + "\n");
            }
            writer.close();

            // Display the contents of the output file
            Scanner outputScanner = new Scanner(new File(destinationFile));
            while (outputScanner.hasNextLine()) {
                System.out.println(outputScanner.nextLine());
            }
            outputScanner.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}