import java.util.*;  
public class SingleDigit   
{      
   static int digSum(int num)  
   {  
       int sum = 0;  
 
       while (num > 0 || sum > 9)  
           {  
              if (num == 0)   
               {  
                 num = sum;  
                 sum = 0;  
               }  

            sum = sum + num % 10;   
            num = num / 10;  
           }  
  
       return sum;  
   }  

   public static void main(String args[])  
   {  
    Scanner in= new Scanner(System.in);
    System.out.println("Enter a number : ");
    int num= in.nextInt();
    System.out.println("The sum of digits is: "+digSum(num));  
    }  
}  