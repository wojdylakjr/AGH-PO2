public class InterestAccount extends BasicAccount {
    InterestAccount(String name, double balance, String pin) {
        super(name, balance, pin);
    }

    public void monthlyUpdate() {
        double interest = super.countInterest();
        super.monthlyUpdate();
        balance += interest;
    }

    @Override
    public String toString() {
        return "type: interest account, " + super.toString();
    }
}
