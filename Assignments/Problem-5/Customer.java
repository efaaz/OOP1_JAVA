public class Customer implements ICustomerOperations {
    private String customerName;
    private String customerId;
    private Account account;

    public Customer(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    @Override
    public void addAccount(Account account) {
        this.account = account;
        System.out.println("Account added for customer " + customerName);
    }

    @Override
    public void deleteAccount() {
        if (this.account != null) {
            System.out.println("Account " + this.account.accountNumber + " deleted.");
            this.account = null;
        } else {
            System.out.println("No account to delete.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer [Name: " + customerName + ", ID: " + customerId + "]");
        if (account != null) {
            account.displayInfo();
        } else {
            System.out.println("No account associated.");
        }
    }

    @Override
    public void search(String accountNumber) {
        if (this.account != null && account.accountNumber.equals(accountNumber)) {
            System.out.println("Account found for customer " + customerName);
            account.displayInfo();
        } else {
            System.out.println("Account not found.");
        }
    }
}
