package Locations;

public class SafeHouse {



    private final int Samurai_Life=21;
    private final int Archer_Life=18;
    private final int Knight_Life=24;

    private int spareLife=15;


    public int fullHealth(String name,int health) {


        switch (name) {
            case "Samuray" -> {

                if (health < Samurai_Life) {


                    int i=1;

                    while (this.spareLife > 0 && health != Samurai_Life) {

                        System.out.println (i+". Sağlık Yüklemesi:");

                        i++;


                        this.spareLife--;
                        health++;

                        System.out.println("Sağlık: " + health);
                        System.out.println("Kalan Yedek Sağlık: " + this.spareLife);




                    } ;

                    if (health == this.Samurai_Life) {

                        System.out.println("Sağlığınız %100");

                    } else System.out.println ("Yedek sağlığınız tükenmiştir.\nSağlık: "+health);
                } else System.out.println("Canınız %100 olduğundan dolayı can arttırımı gerçekleşememektedir.");
            }
            case "Okçu" -> {


                if (health < Archer_Life) {

                    do {

                        this.spareLife--;
                        health++;


                    } while (this.spareLife > 0 && health != Archer_Life);

                    if (health == this.Archer_Life) {

                        System.out.println("Sağlık: " + health);
                        System.out.println("Kalan Yedek Sağlık: " + this.spareLife);

                    } else System.out.println ("Yedek sağlığınız tükenmiştir.\nSağlık: "+health);
                } else System.out.println("Canınız %100 olduğundan dolayı can arttırımı gerçekleşememektedir.");
            }
            case "Şövalye" -> {

                if (health < Knight_Life) {

                    do {

                        this.spareLife--;
                        health++;


                    } while (this.spareLife > 0 && health != Knight_Life);

                    if (health == this.Knight_Life) {

                        System.out.println("Sağlık: " + health);
                        System.out.println("Kalan Yedek Sağlık: " + this.spareLife);

                    }  else System.out.println ("Yedek sağlığınız tükenmiştir.");
                } else System.out.println("Canınız %100 olduğundan dolayı can arttırımı gerçekleşememektedir.");
            }
        }

return health;

    }


    public int getSpareLife() {
        return spareLife;
    }





}
