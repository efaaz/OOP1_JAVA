public class Vehicle{
    protected String brand;
    protected int speed;

    public Vehicle(){
        System.out.println("Vehicle is created");
    }
    public Vehicle(String brand, int speed){
        this.brand = brand;
        this.speed = speed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void showDetails(){
        System.out.println("Brand: " + brand + " Speed: " + speed);
    }
}