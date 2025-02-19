import Account.*;
import Address.Address;
import Address.AddressManager;
import Insurance.*;

import java.util.Scanner;


public class Main {

   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {


        theProgramPart:

        while (true) {

            System.out.println ("""
                    -------Insurance Interface------
                    1- Log In
                    2- Create An Account
                    0- Exit the Program
                    Choice:\s""");


                int choice= scanner.nextInt();

            switch (choice) {
                case 1:logIn();
                break ;
                case 2:createAccount();
                break ;
                case 0: break theProgramPart;
                default: System.out.println ("Choice is not valid!");

            }



    }






}

    public static void logIn() {
        if (AccountManager.logIn())
            accountMenu(AccountManager.getAccessedAccount());
        else runProgram();
    }

    public static void createAccount() {

        AccountManager.createAccount();
        runProgram();
    }

    public static void accountMenu(Account account) {

        accountMenuPart:

        while (true) {

            System.out.println ("""
                    -------Account Menu-------
                    1- Insurance Transactions
                    2- Address Options
                    3- Person's Information
                    0- Exit
                    Choice:\s""");

            int choice= scanner.nextInt();

            switch (choice) {

                case 1: insuranceMenu(account);
                break;
                case 2: addressMenu(account);
                break ;
                case 3:account.showInfo();
                break ;
                case 0: break accountMenuPart;
                default: System.out.println ("Choice is not valid!");

            }

        }

    }
    public static void insuranceMenu(Account account) {

        insuranceMenuPart:

        while (true) {

System.out.println ("""
        -------Insurance Menu-------
        1- Show Insurances
        2- Add Insurance
        3- Remove Insurance
        0- Exit""");

 int choice= scanner.nextInt();
 switch (choice) {

     case 1: InsuranceManager.printInsurances(account);
     break;
     case 2: InsuranceManager.addInsurance(account);
     break;
     case 0:
         break insuranceMenuPart;
         default: System.out.println ("Choice is not valid!");
 }




        }
    }

    public static void addressMenu(Account account) {

        addressMenuStage:
        while (true) {

            System.out.println ("""
                    -------Address Menu-------
                    1- Show Address
                    2- Add Address
                    3- Remove Address
                    0- Exit
                    Choice:\s""");
            int choice= scanner.nextInt();
            switch (choice) {

                case 1: AddressManager.printAddress(account.getUser().getADDRESSES());
                        break;
                case 2: AddressManager.addAddress(account.getUser().getADDRESSES());
                break;
                case 3:AddressManager.removeAddress(account.getUser().getADDRESSES());
                break ;
                case 0:
                    break addressMenuStage;
                    default: System.out.println ("Choice is not valid!");

            }
        }
    }



}

