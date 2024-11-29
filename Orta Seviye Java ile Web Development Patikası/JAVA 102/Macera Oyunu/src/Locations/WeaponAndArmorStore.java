package Locations;

public abstract class WeaponAndArmorStore {

    private String name;
    private int id;
    private int money;

    public WeaponAndArmorStore(String name, int id, int money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getMoney() {
        return money;
    }

}

