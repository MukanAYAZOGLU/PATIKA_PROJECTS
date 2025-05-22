package Account;

import Address.Address;

import java.util.ArrayList;

public class User {

    private final String NAME;
    private final String SURNAME;
    private final int AGE;
    private final String JOB;
    private final String E_MAIL;
    private final String PASSWORD;
    private final String LAST_ACCESS;
    private final ArrayList<Address> ADDRESSES;

    public User(String name, String surname, int age, String job, String eMail, String password, String lastAccess) {
        NAME = name;
        SURNAME = surname;
        AGE = age;
        JOB = job;
        E_MAIL = eMail;
        PASSWORD = password;
        LAST_ACCESS = lastAccess;
        ADDRESSES = new ArrayList<>();
    }


    public String toString() {


        return "--------------Account Information--------------"
                +"\nName: " + NAME
                +"\nSurname: " + SURNAME
                 +"\nAge: " + AGE
                +"\nJob: " + JOB
                +"\nEmail: " + E_MAIL
                +"\nLast Access: " + LAST_ACCESS;
    }


    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public int getAGE() {
        return AGE;
    }

    public String getJOB() {
        return JOB;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getLAST_ACCESS() {
        return LAST_ACCESS;
    }

    public ArrayList<Address> getADDRESSES() {
        return ADDRESSES;
    }
}
