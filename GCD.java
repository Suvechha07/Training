public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        
        if (args.length < 10) {
            System.out.println("Usage: java GCD <num1> <num2> ... <num10>");
            System.out.println("Please provide at least 5 pairs of numbers.");
            return;
        }
        if (args.length % 2 != 0) {
            System.out.println("Invalid number of arguments. Ensure you provide pairs of numbers.");
            return;
        }
         int numberOfPairs = args.length / 2;

        if (numberOfPairs < 10) {
            System.out.println("The array must contain at least 5 pairs of numbers.");
            return;
        }
    System.out.println("GCD of the pairs:");
        for (int i = 0; i < numberOfPairs; i++) {
            try {
                int num1 = Integer.parseInt(args[2 * i]);
                int num2 = Integer.parseInt(args[2 * i + 1]);
                int resultGCD = gcd(num1, num2);
                System.out.println(num1 + " and " + num2 + " -> GCD: " + resultGCD);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + args[2 * i] + " or " + args[2 * i + 1]);
            }
        }
    }
}
