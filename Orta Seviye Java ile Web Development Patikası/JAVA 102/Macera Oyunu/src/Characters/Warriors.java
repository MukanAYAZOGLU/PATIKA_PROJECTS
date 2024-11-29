package Characters;

public class Warriors extends Characters{

    private int blocking;


    public Warriors(String name, int id,int blocking, int damage, int health, int money) {
        super(name, id, damage, health, money);
        this.blocking=blocking;
    }




    public void printWarrior() {

        System.out.println("Türü: "+this.getName()+" \t ID: "+this.getId()+" \t Engelleme: "+this.getBlocking() + " \t Sağlık: "+this.getHealth()+" \t Para: "+this.getMoney()+" \t Hasar: "+this.getDamage());

    }

    public int getBlocking() {
        return blocking;
    }

    public void setBlocking(int blocking) {
        this.blocking = blocking;
    }
}
