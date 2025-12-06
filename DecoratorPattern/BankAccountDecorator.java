package DecoratorPattern;

interface BankAccountDecorator {
    String showAccountType();

    double getInterestRate();

    double getBalance();

    String showBenefits();

    double computeBalanceWithInterest();

    String showInfo();
}
