import java.util.*;

public class evenandodd 
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter array elements : ");
            arr[i]=in.nextInt();
        }
        int ce=0;
        int co=0;
        for(int i=0;i<n;i++)
        {
            if (arr[i] % 2 ==0)
            {
                ce++;
            }
            else
            {
                co++;
            }
        }
        System.out.println("Even numbers : "+ce);
        System.out.println("Odd numbers : "+co);
    }
    
}
