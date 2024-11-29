package Player;

import java.util.Random;

public class Inventory {


    private boolean bWater;
    private boolean bFood;
    private boolean bFirewood;
    private final Random rdm = new Random();



    public String getGoods(String location) {

        if (location.equals("Nehir")) {

            return getWater();

        } else if (location.equals("Mağara")) {

            return getFood();

        } else  {
            return getFirewood();

        }

    }


    public String chanceStuff () {

        int randomNumber=rdm.nextInt(0,101) ;

        if (randomNumber<=15){


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=20){

                System.out.println ("Kazanılan Silah: Tüfek");
                return "Tüfek";

            } else if (randomNumber<=50) {

                System.out.println ("Kazanılan Silah: Kılıç");
                return "Kılıç";


            } else{
                System.out.println ("Kazanılan Silah: Tabanca");
                return "Tabanca";

            }

        } else if (randomNumber<=50) {


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=15){

                System.out.println ("Kazanılan Zırh: Hafif Zırh");
                return "Hafif Zırh";


            } else if (randomNumber<=30) {

                System.out.println ("Kazanılan Zırh: Orta Zırh");
                return "Orta Zırh";



            } else{
                System.out.println ("Kazanılan Zırh: Ağır Zırh");
                return "Ağır Zırh";


            }



        }else if (randomNumber<=75){


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=50){

                System.out.println ("Kazanılan Para: 1");
                return "1";

            } else if (randomNumber<=80) {

                System.out.println ("Kazanılan Para: 5");
                return "5";


            } else{
                System.out.println ("Kazanılan Para: 10");
                return "10";

            }

        }else {

            return "Hiçbir şey kazanmadınız.";

        }



    }




    public boolean isbWater() {
        return bWater;
    }

    public void setbWater(boolean bWater) {
        this.bWater = bWater;
    }

    public boolean isbFood() {
        return bFood;
    }

    public void setbFood(boolean bFood) {
        this.bFood = bFood;
    }

    public boolean isbFirewood() {
        return bFirewood;
    }

    public void setbFirewood(boolean bFirewood) {
        this.bFirewood = bFirewood;
    }

    public String getWater() {
        return "Su";
    }

    public String getFood() {
        return "Yemek";
    }

    public String getFirewood() {
        return "Odun";
    }
}
