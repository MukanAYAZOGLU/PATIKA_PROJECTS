package Account;

import Insurance.Insurance;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account>{

    private static User user = null;
    private final double rate;
    private final ArrayList<Insurance> insurances;


    Account(User user, double rate) {
        this.user = user;
        this.rate = rate;
        this.insurances = new ArrayList<>();
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

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }


    @Override
    public int compareTo(Account account) {
        return this.user.getE_MAIL().compareTo(account.getUser().getE_MAIL());
    }
}
