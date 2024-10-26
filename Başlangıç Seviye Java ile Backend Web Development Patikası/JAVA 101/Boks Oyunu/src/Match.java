import java.text.DecimalFormat;

public class Match {

Fighter f1;
Fighter f2;
int minWeight;
int maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight ) {
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
        this.f1 = f1;
        this.f2 = f2;
    }

void run() {

if (isCheck()) {

    while (this.f1.health>=0 && this.f2.health>=0) {

        System.out.println("-------------");
        System.out.println("Yeni round.");


        if (isChance()) {


            this.f2.health=this.f1.hit(f2);
            System.out.println(this.f2.name+" Sağlık: "+this.f2.health);

            if (isWin()) {
                break;

            }
        } else {



            this.f1.health=this.f2.hit(f1);
            System.out.println(this.f1.name+" Sağlık: "+this.f1.health);


            if (isWin()) {
                break;

            }
        }

    }


} else
    System.out.println("Dövüşçülerin sikletleri uymuyor.");


}



    boolean isCheck() {

        return (this.f1.weight>=minWeight && this.f1.weight<=maxWeight) && (this.f2.weight>=minWeight && this.f2.weight<=maxWeight);

    }


    boolean isWin () {
        if (this.f1.health<=0) {
            System.out.println(this.f2.name+" kazandı.");
            return true;

        } else if (this.f2.health<=0) {
            System.out.println(this.f1.name+" kazandı.");
            return true;


        }

        return false;

    }

    boolean isChance() {
        double randomNumber= Math.random()*100;
        return randomNumber>=50;

    }


}
