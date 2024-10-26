public class Employee {

String name;
double salary;
int workHours;
int hireYear;
double tax;
double bonus;
double interest;
int currentYear=2021;



    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    double tax(){

        if (this.salary>1000) {

            this.tax=this.salary*0.03;

            return this.tax;
        }

        return 0;
    }


double bonus () {

    if (this.workHours>40) {

        this.bonus=(this.workHours-40)*30;
        return this.bonus;
    } else
        return 0;

}

double raiseSalary() {

    if (currentYear-this.hireYear<10) {

        this.interest=this.salary*0.05;
        return this.interest;

    }else if (currentYear-this.hireYear<20) {

        this.interest=this.salary*0.10;
        return this.interest;


    } else {
        this.interest=this.salary*0.15;
        return this.interest;

    }

}

    void printEmployeeInfo () {

    System.out.println("Adı: "+this.name);
    System.out.println("Maaşı: "+this.salary);
    System.out.println("Çalışma Saati: "+this.workHours);
    System.out.println("Başlangıç Yılı: "+this.hireYear);
    System.out.println("Vergi: "+tax());
    System.out.println("Bonus: "+bonus());
    System.out.println("Maaş artışı: "+raiseSalary());
    System.out.println("Vergi ve Bonuslar ile birlikte maaş: "+((this.salary+bonus())-tax()));
    System.out.println("Toplam Maaş: "+((this.salary+bonus())-tax()+raiseSalary()));




}




}
