public abstract class Account implements IAccountOperation {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void transfer(Account to, double amount) {
        if (amount <= balance) {
            this.withdraw(amount);
            to.deposit(amount);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    public abstract void displayInfo();
}
