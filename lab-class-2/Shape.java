public class Shape
{
	protected double value;
	
	public Shape(){System.out.println("Default Shape");}
	public Shape(double value){this.value = value;}
	
	public void setValue(double value){this.value = value;}
	public double getValue(){return value;}
	
	public double getArea(){return 9.99;}
}