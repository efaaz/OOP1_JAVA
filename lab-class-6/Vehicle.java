public class Vehicle {
    protected String model;
    protected double price;

    public Vehicle() {
        System.out.println("Default constructor of Vehicle");
    }

    public Vehicle(String model) {
        this.model = model;
    }

    public Vehicle(String model, double price) {
        this.model = model;
        this.price = price;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel(){
        return model;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void start() {
        System.out.println("Vehicle is starting");
    }

    public void start(String mode) {
        System.out.println("Vehicle is starting in " + mode + " mode");
    }
    public void showDetails() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}
