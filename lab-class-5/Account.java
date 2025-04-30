public class Account {
    private int accountNum;
    private String holderName;
    private double balance;

    public Account() {
        System.out.print("");
    }

    public Account(int accountNum, String holderName, double balance) {
        this.accountNum = accountNum;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setAccountHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public String getAccountHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void showDetails() {
        System.out.println("Account holder name is: " + holderName);
        System.out.println("Account number is: " + accountNum);
        System.out.println("Accout balance is: " + balance);
    }
}