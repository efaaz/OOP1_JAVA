public class Start {
    public static void main(String[] args) {
        Customer c1 = new Customer("X", "123");
        Customer c2 = new Customer("Y", "456");

        Account sa = new SavingsAccount("SAV123", 1000.0, 5.0);
        Account fa = new FixedAccount("FIX456", 5000.0, 3);
        c1.addAccount(sa);
        c1.displayDetails();

        System.out.println("-----------------------------");

        sa.deposit(500);
        sa.withdraw(300);
        sa.displayInfo();
        double interestRate = ((SavingsAccount) sa).getInterestRate();
        System.out.println("interestRate of Savings Account: " + interestRate + "%");
        System.out.println("-----------------------------");

        c2.addAccount(fa);
        c2.displayDetails();
        
        System.out.println("-----------------------------");


        sa.deposit(500);
        sa.withdraw(300);
        sa.displayInfo();
    }
}
