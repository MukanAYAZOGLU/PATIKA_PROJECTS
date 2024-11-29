package Locations;

public class Weapon extends WeaponAndArmorStore
{

    private int damage;


    public Weapon(String name, int id, int money, int damage) {
        super(name, id, money);
        this.damage = damage;
    }


    public void printWeapon(Weapon weapon) {

        System.out.println ("Türü: "+getName()+" \t ID: "+getId()+" \t Para: "+getMoney()+" \t Hasar: "+damage);

    }

    public int getDamage() {
        return damage;
    }
}
