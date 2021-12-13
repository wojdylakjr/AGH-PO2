public class CheckingAccount extends BasicAccount {
    int numberOfTransactions = 0;

    CheckingAccount(String name, double balance, String pin) {
        super(name, balance, pin);
    }

    public void monthlyUpdate() {
        double interest = super.countInterest();
        double fees = numberOfTransactions * 0.5;
        super.monthlyUpdate();
        balance -= fees;
        balance += interest;
        numberOfTransactions = 0;
    }

    public void deposit(double value) {
        super.deposit(value);
        ++numberOfTransactions;
    }

    public void withdraw(double value) {
        super.withdraw(value);
        ++numberOfTransactions;
    }

    public double countFees() {
        if (balance < 100) {
            return 10;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "type: checking account, " + super.toString();
    }
}
