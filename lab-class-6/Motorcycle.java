public class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }
    public boolean getHasCarrier() {
        return hasCarrier;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting smoothly");

    }

    public void showDetails() {
        super.showDetails();
        System.out.println("Has carrier: " + hasCarrier);
    }
}
