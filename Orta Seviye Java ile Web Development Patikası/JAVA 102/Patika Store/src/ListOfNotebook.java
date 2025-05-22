import java.util.Scanner;

public class ListOfNotebook {

    Scanner scan= new Scanner(System.in);

    private String id;
    private String name;
    private double price;
    private String brand;
    private int storing;
    private double screen;
    private int ram;

    public ListOfNotebook(String id, String name, double price, String brand, int storing, double screen, int ram) {
        this.id = id;
        this.name = name;this.price = price;
        this.brand = brand;
        this.storing = storing;
        this.screen = screen;
        this.ram = ram;
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

    public int getRAM() {
        return ram;
    }
}
