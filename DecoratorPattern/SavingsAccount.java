package DecoratorPattern;

class SavingsAccount implements BankAccountDecorator {
    private int accountNumber;
    private String accountName;
    private double balance;

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String showAccountType() {
        return "Savings Account";
    }

    public double getInterestRate() {
        return 1.0;
    }

    public double getBalance() {
        return balance;
    }

    public String showBenefits() {
        return "Standard Savings Account";
    }

    public double computeBalanceWithInterest() {
        return balance + (balance * getInterestRate() / 100);
    }

    public String showInfo() {
        return "Account Number: %d\nAccount Name: %s\nBalance: %.1f".formatted(accountNumber, accountName, balance);
    }
}
