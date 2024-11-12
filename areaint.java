import java.util.*;

 interface circle
  {

    void calculateareacir();
}
  interface triangle
 {
 
    void calculateareatri();
 }

 
 interface area extends circle,triangle
 {
 
    
 }    

 class areaint implements area
 {
     void calculateareacir(double r)
     {
        double ar=3.14*r*r;
        System.out.println("Thea area of circle is : "+ar);
     }
     void calculateareatri(double b,double h)
     {
        Double are=0.5*b*h;
        System.out.println("Thea area of triangle is : "+are);
     }
 

 public static void main(String args[])
 {
     Scanner in=new Scanner(System.in);
     areaint obj=new areaint();
     System.out.println("The radius of circle is : ");
     double rad=in.nextDouble();
     System.out.println("The base of triangle is : ");
     double base=in.nextDouble();
     System.out.println("The height of triangle is : ");
     double height=in.nextDouble();
     obj.calculateareacir(rad);
     obj.calculateareatri(base,height);
 }
@Override
public void calculateareacir() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateareacir'");
}
@Override
public void calculateareatri() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateareatri'");
}
}