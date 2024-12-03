package Insurance;

import Account.Account;

import java.util.Comparator;
import java.util.Scanner;

public class InsuranceManager {

static Scanner scanner = new Scanner(System.in);

    public static void addInsurance(Account account) {

        System.out.println ("Add Insurance");
        System.out.println ("""
                1-Car Insurance
                2-Health Insurance
                3-Residence Insurance
                4-Travel Insurance""");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:account.getInsurances().add(new CarInsurance(account));
            break;
            case 2:account.getInsurances().add(new HealthInsurance(account));
            break;
            case 3:account.getInsurances().add(new ResidenceInsurance(account));
            break;
            case 4:account.getInsurances().add(new TravelInsurance(account));
            break;
            default:System.out.println ("Seçenek dışı seçim yaptınız.");

        }

        account.getInsurances().sort(Comparator.comparing(Insurance::getType));

    }

    public static void printInsurances(Account account) {
        for(Insurance a: account.getInsurances() ) {

            System.out.println(a.toString());
            
        }
    }



}
