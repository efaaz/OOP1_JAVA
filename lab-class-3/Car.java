public class Car extends Vehicle {
    protected String fuelType;

    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
    public Car(String brand, int speed, String fuelType) {
        super(brand, speed);
        this.fuelType = fuelType;
    }
    public void showCarDetails(){
        System.out.println("Brand: " + brand);
        System.out.println(" Speed: " + speed);
        System.out.println(" Fuel Type: " + fuelType);
    }
}
