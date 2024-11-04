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


    public void chanceStuff () {

        int randomNumber=rdm.nextInt(0,101) ;

        if (randomNumber<=15){


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=20){

                System.out.println ("Kazanılan Silah: Tüfek");

            } else if (randomNumber<=50) {

                System.out.println ("Kazanılan Silah: Kılıç");

            } else{
                System.out.println ("Kazanılan Silah: Silah");
            }

        } else if (randomNumber<=50) {


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=15){

                System.out.println ("Kazanılan Zırh: Hafif Zırh");

            } else if (randomNumber<=30) {

                System.out.println ("Kazanılan Zırh: Orta Zırh");


            } else{
                System.out.println ("Kazanılan Zırh: Ağır Zırh");

            }



        }else if (randomNumber<75){


            randomNumber=rdm.nextInt(0,101) ;


            if (randomNumber<=50){

                System.out.println ("Kazanılan Para: 1");

            } else if (randomNumber<=80) {

                System.out.println ("Kazanılan Para: 5");


            } else{
                System.out.println ("Kazanılan Para: 10");

            }

        }else {

            System.out.println ("Hiçbir şey kazanmadınız.");
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
