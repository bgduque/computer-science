package DecoratorPattern;

class GSave implements BankAccountDecorator {
    private final SavingsAccount account;

    GSave(SavingsAccount account) {
        this.account = account;
    }

    public String showAccountType() {
        return "GSave";
    }

    public double getInterestRate() {
        return 2.5;
    }

    public double getBalance() {
        return account.getBalance();
    }

    public String showBenefits() {
        return account.showBenefits() + ", GCash Transfer";
    }

    public double computeBalanceWithInterest() {
        return getBalance() + (getBalance() * getInterestRate() / 100);
    }

    public String showInfo() {
        return account.showInfo();
    }
}
