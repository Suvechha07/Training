import java.util.*;
abstract class shape
{
    public abstract void calcArea();
}
class Circle extends shape
{
    private double r;
    public Circle(double r)
    {
        this.r=r;
    }
   
   public void calcArea()
    {
        double a=3.14*r*r;
        System.out.println("The area of the circle is : "+a);
    }

public void calcArea(double rad) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calcArea'");
}
    
}
class Triangle extends shape
{
    private double h;
    private double b;

    public Triangle(double b, double h)
     {
      this.b = b;
      this.h = h;  
    }

    public void calcArea()
    {
        double ar=0.5*b*h;
        System.out.println("The area of the triangle is : "+ar);
    }

    public void calcArea(double ba, double he) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcArea'");
    }
}
public class area
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("The radius of the circle is : ");
        double rad=in.nextDouble();
        System.out.println("The base of the triangle is : ");
        double ba=in.nextDouble();
        System.out.println("The height of the triangle is : ");
        double he=in.nextDouble();
        Circle obj1=new Circle(rad);
        Triangle obj2=new Triangle(ba,he);
        obj1.calcArea();
        obj2.calcArea();

    }
}