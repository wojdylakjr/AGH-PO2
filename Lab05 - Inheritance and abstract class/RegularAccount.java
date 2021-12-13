public class RegularAccount extends BasicAccount {
    private boolean isPunished = false;

    RegularAccount(String name, double balance, String pin) {
        super(name, balance, pin);
    }


    public void test() {
        System.out.println("Update regular");
    }

    public void monthlyUpdate() {
        super.monthlyUpdate();
        balance -= countFees();
    }

    public double countFees() {
        if (isPunished) {
            isPunished = false;
            return 10;
        } else {
            return 0;
        }
    }

    public void withdraw(double value) {
        super.withdraw(value);
        if (balance < 500) {
            isPunished = true;
        }
    }

    @Override
    public String toString() {
        return "type: regular account, " + super.toString();
    }

}
