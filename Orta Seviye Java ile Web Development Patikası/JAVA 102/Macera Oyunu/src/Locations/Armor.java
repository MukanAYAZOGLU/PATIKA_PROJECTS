package Locations;

public class Armor extends WeaponAndArmorStore{

    private int blocking;


    public Armor(String name, int id, int blocking, int money ) {
        super(name, id, money);
        this.blocking = blocking;

    }




    public void printArmor(Armor armor) {

        System.out.println ("Türü: "+getName()+" \t ID: "+getId()+" \t Engelleme: "+getBlocking()+" \t Para: "+getMoney());

    }

    public int getBlocking() {
        return blocking;
    }
}
