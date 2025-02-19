import java.util.List;
import java.util.Scanner;

public class ListOfCellPhone {

    Scanner scan = new Scanner(System.in);
    String answer;

    private String id;
    private String name;
    private double price;
    private String brand;
    private int storing;
    private double screen;
    private double camera;
    private double battery;
    private int ram;
    private String colour;

    public ListOfCellPhone(String id, String name, double price, String brand, int storing, double screen, double camera, double battery, int ram, String colour) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.storing = storing;
        this.screen = screen;
        this.camera = camera;
        this.battery = battery;
        this.ram = ram;
        this.colour = colour;
    }







    public String getID() {
        return id;
    }

    public String getNAME() {
        return name;
    }

    public double getPRICE() {
        return price;
    }

    public String getBRAND() {
        return brand;
    }

    public int getSTORING() {
        return storing;
    }

    public double getSCREEN() {
        return screen;
    }

    public double getCAMERA() {
        return camera;
    }

    public double getBATTERY() {
        return battery;
    }

    public int getRAM() {
        return ram;
    }

    public String getCOLOUR() {
        return colour;
    }
}