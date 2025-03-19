public class Triangle extends Shape {
	public double base;
    public Triangle(){System.out.println("Triangle - Default constructor");}
    public Triangle(double height, double base){
        super(height);
		this.base = base;
    }
    public void setLength(double height){super.setValue(height);}
	public void setWidth(double base){this.base = base;}
	
	public double getLength(){return super.getValue();}
	public double getWidth(){return base;}
	
	@Override
	public double getArea(){return super.getValue()*base*0.5;}
}
