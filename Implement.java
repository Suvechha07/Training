import java.util.Scanner;

interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {

    public abstract double calcArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Implement {
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        System.out.println("The radius of the circle is : ");
        double rad=in.nextDouble();

        Circle circle = new Circle(rad);

        System.out.println("Area of Circle: " + circle.calcArea());

        circle.draw();
    }
}