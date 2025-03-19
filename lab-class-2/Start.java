import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Circle c1 = new Circle();
		System.out.print("Enter radius: ");
		double rad = input.nextDouble();
		c1.setRadius(rad);
		System.out.println("Your entered radius is: " + c1.getRadius());
		System.out.println("Area is: " + c1.getArea());

		Rectangle r1 = new Rectangle();
		System.out.print("Enter length: ");
		double len = input.nextDouble();
		System.out.print("Enter Width: ");
		double wid = input.nextDouble();
		r1.setLength(len);
		r1.setWidth(wid);
		System.out.println("Your entered length is: " + r1.getLength());
		System.out.println("Your entered width is: " + r1.getWidth());
		System.out.println("Area is: " + r1.getArea());

		System.out.print("Enter radius: ");
		double radius = input.nextDouble();

		Circle c2 = new Circle(radius);

		System.out.println("Your entered radius is: " + c2.getRadius());
		System.out.println("Area is: " + c2.getArea());

		System.out.print("Enter length: ");
		double lenth = input.nextDouble();
		System.out.print("Enter Width: ");
		double width = input.nextDouble();
		Rectangle r2 = new Rectangle(lenth, width);
		System.out.println("Your entered length is: " + r2.getLength());
		System.out.println("Your entered width is: " + r2.getWidth());
		System.out.println("Area is: " + r2.getArea());




		System.out.print("Enter height: ");
		double height = input.nextDouble();
		System.out.print("Enter base: ");
		double base = input.nextDouble();
		Triangle t1 = new Triangle(height, base);
		
		System.out.println("Your entered height is: " + t1.getLength());
		System.out.println("Your entered base is: " + t1.getWidth());
		System.out.println("Area is: " + t1.getArea());
	}
}