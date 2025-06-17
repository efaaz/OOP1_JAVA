public class FixedAccount extends Account {
    private int tenureYear;

    public FixedAccount(String accountNumber, double balance, int tenureYear) {
        super(accountNumber, balance);
        this.tenureYear = tenureYear;
    }

    @Override
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance );
        System.out.println("Tenure: " + tenureYear + " years");
    }
}
