package Insurance;

import Account.Account;

import java.util.Scanner;

public abstract class Insurance {

    Account account;
    String name;
    String type;
    double price;
    double rate;
    String startDate;
    String endDate;

    Scanner scan = new Scanner(System.in);



    public Insurance(Account account, String type, double rate) {
        this.account = account;
        this.type = type;
        this.rate = rate;
        createInsurance();
    }



    public void createInsurance(){

System.out.println ("----------Create New Insurance----------");

System.out.println ("Insurance Name: ");
name = scan.nextLine();
System.out.println ("Insurance Type: ");
type = scan.nextLine();
System.out.println ("Insurance Price: ");
price = scan.nextDouble();
System.out.println ("Insurance Start Date: ");
startDate = scan.nextLine();
System.out.println ("Insurance End Date: ");
endDate = scan.nextLine();

    }



    public double calculate() {

        return price*rate*account.getRate();
    }


    public String toString() {
        return "Name: "+name
                +"\nType: "+type
                +"\nTotal Price: "+price
                +"\nStart Date: "+startDate
                +"\nEnd Date: "+endDate;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
