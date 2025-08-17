

import java.util.Scanner;

interface Shape{
    void calculateArea();
}

class Circle implements Shape{
    double radius , area;

    Circle(double radius){
        this.radius = radius;
    }
    public void calculateArea(){
        area = 3.142*(Math.pow(radius, 2));
        System.out.println(area);
    }
}

class Rectangle implements Shape{
    double length , breadth, area;

    Rectangle(double length , double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public void calculateArea(){
        area = length*breadth;
        System.out.println(area);
    }
}

class Triangle implements Shape{
    double height , base, area;

    Triangle(double height , double base){
        this.height = height;
        this.base = base;
    }
    public void calculateArea(){
        area = (0.5)*height*base;
        System.out.println(area);
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Enter 1 to calculate area of Circle");
        System.out.println("Enter 2 to calculate area of Rectangle");
        System.out.println("Enter 3 to calculate area of Triangle");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter radius of the Circle: ");
                double radius = sc.nextDouble();
                Circle c = new Circle(radius);
                c.calculateArea();
                break;
            
            case 2:
                System.out.print("Enter length of the Rectangle: ");
                double length = sc.nextDouble();
                System.out.print("Enter breadth of the Rectangle: ");
                double breadth = sc.nextDouble();
                Rectangle r = new Rectangle(length,breadth);
                r.calculateArea();
                break;

            case 3:
                System.out.print("Enter base of the Triangle: ");
                double base = sc.nextDouble();
                System.out.print("Enter height of the Triangle: ");
                double height = sc.nextDouble();
                Triangle t = new Triangle(height,base);
                t.calculateArea();
                break;
        
            default:
            System.out.println("Please enter a valid input!!");
                break;
        }
    }
}
