package Insurance;

import Account.Account;

public class CarInsurance extends Insurance{
    private static final double RATE=1.21;
    public CarInsurance(Account account) {
        super(account, "Car Insurance",RATE);
    }
}
