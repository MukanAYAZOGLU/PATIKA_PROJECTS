package Address;

public class BusinessAddress implements Address{

    private final String ADDRESS_NAME;
    private final String FULL_ADDRESS;


    public BusinessAddress(String addressName, String fullAddress) {
        ADDRESS_NAME = addressName;
        FULL_ADDRESS = fullAddress;
    }

    public String getADDRESS_NAME() {
        return ADDRESS_NAME;
    }

    public String getFULL_ADDRESS() {
        return FULL_ADDRESS;
    }


    @Override
    public String getName() {
        return "";
    }
}
