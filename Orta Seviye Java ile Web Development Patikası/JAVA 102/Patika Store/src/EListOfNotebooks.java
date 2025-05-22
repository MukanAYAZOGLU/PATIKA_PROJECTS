public enum EListOfNotebooks {

FIRST(1,"HUAWEI Matebook 14",7000.0,"Huawei",512,14.0,16),

SECOND(2,"LENOVO V14 IGL",3699.0,"Lenovo",2048,15.6,32),

THIRTH(3,"ASUS Tuf Gaming",8199.0,"Asus",2048,15.6,32);



    private final int ID;
    private final String NAME;
    private final double PRICE;
    private final String BRAND;
    private final int STORING;
    private final double SCREEN;
    private final int RAM;

    private EListOfNotebooks(int id, String name, double price, String brand, int storing, double screen, int ram) {
        this.ID = id;
        this.NAME = name;
        this.PRICE = price;
        this.BRAND = brand;
        this.STORING = storing;
        this.SCREEN = screen;
        this.RAM = ram;
    }











    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public double getPRICE() {
        return PRICE;
    }

    public String getBRAND() {
        return BRAND;
    }

    public int getSTORING() {
        return STORING;
    }

    public double getSCREEN() {
        return SCREEN;
    }

    public int getRAM() {
        return RAM;
    }



}
