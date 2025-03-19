public class Circle extends Shape
{	
	public Circle(){System.out.println("Circle - Default constructor");}
	public Circle(double radius){super(radius);}
	
	public void setRadius(double radius){super.setValue(radius);}
	public double getRadius(){return super.getValue();}
	
	public double getArea(){return 3.1416*super.getValue()*super.getValue();}
}