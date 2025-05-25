public class Customer {
    private String name;
    private String phoneNumber;
    private Vehicle[] vehicles = new Vehicle[10];

    public Customer() {
    }

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void addVehicle(Vehicle v) {
        int flag = 0, i;
        for (i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = v;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Vehicle" + vehicles[i].getModel() + " added successfully");
        } else {
            System.out.println("could not added vehicle");
        }
    }

    public void showAllDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.print("Vehicles:");
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                System.out.println("---------------------------");
                vehicles[i].showDetails();
                vehicles[i].start();
            }
        }
    }

    public Vehicle searchVehicle(String model) {
        Vehicle a = null;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {
                if (vehicles[i].getModel() == model) {
                    a = vehicles[i];
                    break;
                }
            }
        }
        return a;
    }

}
