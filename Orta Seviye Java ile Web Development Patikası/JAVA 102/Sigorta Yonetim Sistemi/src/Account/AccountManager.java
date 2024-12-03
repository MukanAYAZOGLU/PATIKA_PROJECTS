package Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {

private static final TreeSet<Account> accounts = new TreeSet<>();
private static Account accessedAccount=null;



static Scanner scanner = new Scanner(System.in);

public static boolean logIn() {

    String eMail;
    String password;

    do {

        System.out.println ("--------------Log In--------------");
        System.out.print ("Please enter your e-mail address: ");
        eMail = System.console().readLine();
        System.out.print ("Please enter your password: ");
        password = System.console().readLine();
        if (eMail.isEmpty() || password.isEmpty()) {
            System.out.println ("Emty e-mail or password\nAccess deniyed!");
            return false;
        }


        }while(!isLoggedIn(eMail,password));

    return true;
}


public static void createAccount() {

    String name;
    String surname;
    String eMail;
    String password;
    String job;
    int age;


    creteAccountLabel:
    while (true) {

System.out.print ("""
        ----------Acoount Type----------
        1-Individual
        2-Enterprise
        0-Exit
        --------------------------------
        Choice:\s""");

    int choice=scanner.nextInt();

    if (choice == 0) {
        break creteAccountLabel;
    }

    System.out.print ("E-Mail: ");
    eMail=System.console().readLine();

    for(Account a:accounts  ) {
        if (a.getUser().getE_MAIL().equals(eMail)) {
            System.out.println ("This account is already exists!");
            continue creteAccountLabel;
        } else if (choice<1 || choice>2) {
            continue creteAccountLabel;
        }

    }


    System.out.print ("Password: ");
    password=System.console().readLine();
    System.out.print ("Name: ");
    name=System.console().readLine();
    System.out.print ("Surname: ");
    surname=System.console().readLine();
    System.out.print ("Job: ");
    job=System.console().readLine();
    System.out.print ("Age: ");
    age=scanner.nextInt();

    switch (choice) {

        case 1: accounts.add(new Individual(new User(name,surname,age,job, eMail,password, getDate())));
            System.out.println ("Account Created! Congratulations!");
        break;
        case 2: accounts.add(new Enterprise(new User(name,surname,age,job, eMail,password, getDate())));
        System.out.println ("Account Created! Congratulations!");
        break;
        case 0: break creteAccountLabel;

        default: System.out.println ("Choice is not valid!");



    }




    }


}

public static String getDate() {

    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    return localDateTime.format(formatter);

}


public static boolean isLoggedIn(String eMail, String password) {

    for(Account a: accounts  ) {
        if (a.getUser().getE_MAIL().equals(eMail)) {
            if (a.getUser().getPASSWORD().equals(password)) {
                accessedAccount=a;
                System.out.println ("You Logged in!");
                return true;
            }
        }

    }

    return false;

}


    public static Account getAccessedAccount() {
        return accessedAccount;
    }

    public static void setAccessedAccount(Account accessedAccount) {
        AccountManager.accessedAccount = accessedAccount;
    }
}
