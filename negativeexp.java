import java.util.*;
 class NegativeNumberException extends Exception{
 
    NegativeNumberException (String msg)
    {
        super(msg);
    }
 
}   

 

public class negativeexp 
{
    public double ProcessInput(double a)
    {
      double d=a*2;
      return d;
    }
    static void validate (double num) throws NegativeNumberException
    {    
        if(num < 0)
        {  
   
         
         throw new NegativeNumberException("The number is negative and cannot be calculated");    
        }  
        else 
        {   
         System.out.println("There is no problem with calculation"); 
           
         }   
      }    
   
    public static void main (String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number");
        double num=in.nextDouble();
        negativeexp obj=new negativeexp();
        double dbl=obj.ProcessInput(num);
        try  
        {  
             
            validate(num);  
            System.out.println("The double is : "+dbl);
        }  
        catch (NegativeNumberException ex)  
        {  
            System.out.println("Caught the exception");  
    
            
            System.out.println("Exception occured: " + ex);  
        }  
        
       
        
    }
    
}
