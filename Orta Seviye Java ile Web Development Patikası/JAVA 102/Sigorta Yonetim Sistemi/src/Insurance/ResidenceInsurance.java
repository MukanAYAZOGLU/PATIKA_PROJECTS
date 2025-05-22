package Insurance;

import Account.Account;

public class ResidenceInsurance extends Insurance{

    private static final double RATE=1.60;
    public ResidenceInsurance(Account account) {
        super(account,"Residence Insurance", RATE);
    }
}
