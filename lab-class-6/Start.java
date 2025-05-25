public class Start {
    public static void main(String[] args) {
        Customer c = new Customer("Anik", "1234567890");

        Vehicle v1 = new Vehicle();
        v1.setModel("Toyota");
        v1.setPrice(20000);
        v1.showDetails();
        v1.start();
        v1.start("eco");

        System.out.println("--------------------");
        Vehicle vcar = new Car();
        vcar.setModel("BMW");
        vcar.setPrice(10000);
        ((Car) vcar).setNumberOfDoors(4);
        vcar.showDetails();
        vcar.start();

        System.out.println("--------------------");
        Vehicle vmoto = new Motorcycle();
        vmoto.setModel("Royal Enfield");
        vmoto.setPrice(5550);
        ((Motorcycle) vmoto).setHasCarrier(false);
        vmoto.showDetails();
        vmoto.start();

        System.out.println("--------------------");

        c.addVehicle(v1);
        c.addVehicle(vcar);
        c.addVehicle(vmoto);

        c.showAllDetails();
        System.out.println("--------------------");

        Vehicle searchedVehicle = c.searchVehicle("Toyota");
        if (searchedVehicle != null) {
            System.out.println("Searched vehicle found:");
            searchedVehicle.showDetails();
        } else {
            System.out.println("Searched vehicle not found.");
        }
    }
}
