package DecoratorPattern;

class UpSave implements BankAccountDecorator {
    private final SavingsAccount account;

    UpSave(SavingsAccount account) {
        this.account = account;
    }

    public String showAccountType() {
        return "UpSave";
    }

    public double getInterestRate() {
        return 4.0;
    }

    public double getBalance() {
        return account.getBalance();
    }

    public String showBenefits() {
        return account.showBenefits() + ", With Insurance";
    }

    public double computeBalanceWithInterest() {
        return getBalance() + (getBalance() * getInterestRate() / 100);
    }

    public String showInfo() {
        return account.showInfo();
    }
}
