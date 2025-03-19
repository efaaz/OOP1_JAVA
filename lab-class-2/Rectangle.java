public class Rectangle extends Shape
{
	private double width;
	
	public Rectangle(){System.out.println("Rectange - Default constructor");}
	public Rectangle(double length, double width)
	{
		super(length);
		this.width = width;
	}
	
	public void setLength(double length){super.setValue(length);}
	public void setWidth(double width){this.width = width;}
	
	public double getLength(){return super.getValue();}
	public double getWidth(){return width;}
	
	@Override
	public double getArea(){return super.getValue()*width;}
}