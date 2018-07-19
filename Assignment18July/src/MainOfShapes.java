import java.util.*;

public class MainOfShapes {

	public static void main(String[] args)

	{

		AreaOfShapes as = new AreaOfShapes();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter height");
		double height = sc.nextDouble();
		System.out.println("enter width");
		double width = sc.nextDouble();
		System.out.println("enter radius");
		double radius = sc.nextDouble();

		double area_triangle = as.areaOfTriangle(height, width);
		double area_circle = as.areaOfCircle(radius);
		double area_square = as.areaOfSquare(width);
		double area_rectangle = as.areaOfRectangle(height, width);

		System.out.println("Area of triangle is " + area_triangle);
		System.out.println("Area of circle is " + area_circle);
		System.out.println("Area of rectangle is " + area_rectangle);
		System.out.println("Area of square is " + area_square);
		sc.close();

	}

}
