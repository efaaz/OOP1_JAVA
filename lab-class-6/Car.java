public class Car extends Vehicle {
    private int numberOfDoors;

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Car is starting with a roar");

    }

    public void showDetails() {
        super.showDetails();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}
