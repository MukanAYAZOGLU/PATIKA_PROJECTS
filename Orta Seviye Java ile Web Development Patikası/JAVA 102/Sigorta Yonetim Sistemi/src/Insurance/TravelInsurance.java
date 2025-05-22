package Insurance;

import Account.Account;

public class TravelInsurance extends Insurance{


    private static final double RATE = 2.30;

    public TravelInsurance(Account account) {
        super(account, "Travel Insurance", RATE);
    }
}
