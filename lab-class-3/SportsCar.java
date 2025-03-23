public class SportsCar extends Car {
    protected boolean turbo;
    SportsCar(String brand, int speed, String fuelType, boolean turbo) {
        super(brand, speed, fuelType);
        this.turbo = turbo;
    }
    public void showSportsCarDetails(){
        System.out.println("Brand: " + brand);
        System.out.println(" Speed: " + speed);
        System.out.println(" Fuel Type: " + fuelType);
        System.out.println(" Turbo mode status: " + turbo);
    }
}
