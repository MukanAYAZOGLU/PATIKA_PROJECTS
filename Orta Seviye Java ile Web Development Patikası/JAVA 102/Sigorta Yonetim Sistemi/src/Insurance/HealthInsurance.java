package Insurance;

import Account.Account;

public class HealthInsurance extends Insurance{
    private static final double RATE=1.32;
    public HealthInsurance(Account account) {
        super(account, "Health Insurance", RATE);
    }
}
