 class CheckArgument extends Exception 
{
    public CheckArgument(String message) {
        super(message);
    }
}
public class chkargs 
{
    public static void main(String[] args) throws CheckArgument {
        if (args.length < 4) {
            throw new CheckArgument("Please provide at least four arguments.");
        }

        int sum = 0;
        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                sum += num * num;
            } catch (NumberFormatException e) {
                System.err.println("Error parsing argument: " + arg);
            }
        }

        System.out.println("Sum of squares: " + sum);
    }
}