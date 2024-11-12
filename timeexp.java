import java.util.*;
class HrsException extends Exception{
 
    HrsException (String msg1)
    {
        super(msg1);
    }
 
}   
class MinException extends Exception{
 
    MinException (String msg2)
    {
        super(msg2);
    }
 
}   
class SecException extends Exception{
 
    SecException (String msg3)
    {
        super(msg3);
    }
 
}   

public class timeexp 
{
    static void validate1 (int h) throws HrsException
    {    
        if(h<0 && h>24)
        {  
   
         
         throw new HrsException("The hour is not valid");    
        }  
        else 
        {   
         System.out.println("There is no problem with calculation"); 
           
         } 
        }  
         static void validate2 (int m) throws MinException
    {    
        if(m<0 && m>60)
        {  
   
         
         throw new MinException("The minute is not valid");    
        }  
        else 
        {   
         System.out.println("There is no problem with calculation"); 
           
         }  
    } 
     static void validate3 (int s) throws SecException
    {    
        if(s<0 && s>60)
        {  
   
         
         throw new SecException("The second is not valid");    
        }  
        else 
        {   
         System.out.println("There is no problem with calculation"); 
           
         }   
         
      } 
    public static void main(String[] args) throws Exception 
    {
        
    
    Scanner in=new Scanner(System.in);
        System.out.println("Enter the hour : ");
        int h=in.nextInt();
        System.out.println("Enter the minutes : ");
        int m=in.nextInt();
        System.out.println("Enter the seconds : ");
        int s=in.nextInt();
    
      try  
        {  
             
            validate1(h);  
            System.out.println("The hour is : "+h);
        }  
        catch (HrsException ex1)  
        {  
            System.out.println("Caught the exception");  
    
            
            System.out.println("Exception occured: " + ex1);  
        }  
        try  
        {  
             
            validate2(m);  
            System.out.println("The minute is : "+m);
        }  
        catch (MinException ex2)  
        {  
            System.out.println("Caught the exception");  
    
            
            System.out.println("Exception occured: " + ex2);  
        }  
        try  
        {  
             
            validate3(s);  
            System.out.println("The second is : "+s);
        }  
        catch (SecException ex3Exception)  
        {  
            System.out.println("Caught the exception");  
    
            
            System.out.println("Exception occured: " + ex3Exception);  
        }  
        

     }
    }

