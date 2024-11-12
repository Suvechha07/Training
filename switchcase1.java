import java.io.*;
public class switchcase1 
{
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args[])throws IOException
    {
        InputStreamReader r=new InputStreamReader(System.in);   
        BufferedReader in=new BufferedReader(r);
        System.out.println("Enter 1st integer : ");
        int a=in.read();
        in.readLine();
        System.out.println("Enter 2nd integer : ");
        int b=in.read();
        in.readLine();
        System.out.println("Enter 1 for +, 2 for -, 3 for *, 4 for / ");
        System.out.println("Enter your choice : ");
        int ch=in.read();
        in.readLine();
        String n;
        do
        {
        switch(ch)
        {
            case 1:System.out.println("Result : "+(a+b));
            break;
            case 2:System.out.println("Result : "+(a-b));
            break;
            case 3:System.out.println("Result : "+(a*b));
            break;
            case 4:System.out.println("Result : "+(a/b));
            break;
            default:System.out.println("Invalid Choice");
            break;

        }
        System.out.println("Do you want to go again?(Y/N)");
        n=in.readLine();
        }while(n=="Y");
    }
    
}
