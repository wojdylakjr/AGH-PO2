import java.lang.Math;

public abstract class BasicAccount {
    protected String name;
    protected double balance;
    protected String pin;

    BasicAccount(String name, double balance, String pin) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }

    public void withdraw(double value) {
        if (balance - value >= 0) {
            balance -= value;
        } else {
            System.out.println("Nie mozna wyplacic");
        }
    }

    public boolean checkName(String name) {
        return (this.name.equals(name));
    }

    public boolean checkPin(String pin) {
        return (this.pin.equals(pin));
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        balance += value;
    }

    public double countFine() {
        return Math.min(10.0, 0.1 * balance);
    }

    public double countInterest() {
        return 0.02 * balance;
    }


    public void monthlyUpdate() {
        balance -= countFine();
    }

    @Override
    public String toString() {
        return "owner: " + name + ", balance: " + balance;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        BasicAccount acc = (BasicAccount) obj;
        return this.name.equals(acc.name) && this.pin.equals(acc.pin) && this.balance == acc.balance;
    }


}