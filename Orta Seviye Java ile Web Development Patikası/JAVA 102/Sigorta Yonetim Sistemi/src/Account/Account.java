package Account;

import Insurance.Insurance;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {
    private final double rate;
    private final User user;
    private final ArrayList<Insurance> insurances;

    Account(User user, double rate) {
        this.user = user;
        this.insurances = new ArrayList<>();
        this.rate = rate;
    }

    public void showInfo() {
        System.out.println(user.toString());
    }

    public User getUser() {
        return user;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public int compareTo(Account account) {
        return this.user.getEmail().compareTo(account.user.getEmail());
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }
}