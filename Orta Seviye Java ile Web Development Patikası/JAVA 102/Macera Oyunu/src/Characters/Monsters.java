package Characters;

import java.util.Random;

public class Monsters extends Characters{

private int monsterNumber;
private final int Zomibe_Health=10;
private final int Vampire_Health=14;
private final int Bear_Health=20;




    public Monsters(String name, int id, int damage, int health, int money) {
        super(name, id, damage, health, money);
    }


    public void printMonster() {
        System.out.println("Türü: "+this.getName()+" \t ID: "+this.getId()+" \t Sağlık: "+this.getHealth()+" \t Para: "+this.getMoney()+" \t Hasar: "+this.getDamage());


    }



    public int makeMonsterNumber() {

    Random rdm = new Random();

    this.monsterNumber=rdm.nextInt(1,4);

    return this.monsterNumber;

}

public int fullMonsterHealth(String monsterName) {

        if (monsterName.equals("Zombi")) {

            return Zomibe_Health;
        } else if (monsterName.equals("Vampire")) {
            return Vampire_Health;
        } else
            return Bear_Health;


}




}
