package Address;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AddressManager {

static Scanner scanner = new Scanner(System.in);
    
public static void addAddress(ArrayList<Address> address) {

String addressName;
String fullAddress;
int choice;

System.out.println ("""
        1-Home Address
        2-Business Address
        Choice:\s""");

choice = scanner.nextInt();


System.out.println ("Address Name: ");
addressName = scanner.next();
System.out.println ("Full Address: ");
fullAddress = scanner.next();


switch (choice) {

    case 1:address.add(new HomeAddress(addressName,fullAddress));
    break;
    case 2:address.add(new BusinessAddress(addressName,fullAddress));
    break;
    default:System.out.println ("Seçenek dışı seçim yaptınız.");

}
reList(address);

}

public static void removeAddress(ArrayList<Address> address) {
    printAddress(address);

    System.out.print ("Select the address that you want to remove: ");
    int choice= scanner.nextInt();
    if (choice <0 || choice > address.size()) {
        System.out.println ("Choice is invalid.");
    } else {
        address.remove(choice-1);
        System.out.println ("Selected address is removed.");
    }


}

public static void printAddress(ArrayList<Address> address) {
    int i=0;
    System.out.println ("-----------Addresses-----------");
    for(Address a: address ) {
        System.out.println (++i+" - "+a.toString());
        System.out.println ("\n-------------------------");

    }
}

public static void reList(ArrayList<Address> address) {
    address.sort(Comparator.comparing(Address::getName));
}


}
