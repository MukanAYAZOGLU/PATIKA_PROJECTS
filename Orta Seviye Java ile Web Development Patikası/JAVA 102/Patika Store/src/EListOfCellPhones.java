public enum EListOfCellPhones {


    FIRST(1,"SAMSUNG GALAXY A51",3199.0,"Samsung",128,6.5,32,4000.0,6,"SİYAH"),
    SECOND(2,"iPhone 11 64 GB",7379.0,"Apple",64,6.1,5,3046.0,6,"Mavi"),
    THIRTH(3,"Redmi Note 10 Pro 8GB",4012.0,"Xiaomi",128,6.5,35,4000.0,12,"Beyaz");



    private final int ID;
    private final String NAME;
    private final double PRICE;
    private final String BRAND;
    private final int STORING;
    private final double SCREEN;
    private final int CAMERA;
    private final double BATTERY;
    private final int RAM;
    private final String COLOUR;

    private EListOfCellPhones(int ID, String NAME, double PRICE, String BRAND, int STORING, double SCREEN, int CAMERA, double BATTERY, int RAM, String COLOUR) {
        this.ID = ID;
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.BRAND = BRAND;
        this.STORING = STORING;
        this.SCREEN = SCREEN;
        this.CAMERA = CAMERA;
        this.BATTERY = BATTERY;
        this.RAM = RAM;
        this.COLOUR = COLOUR;
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

    public int getCAMERA() {
        return CAMERA;
    }

    public double getBATTERY() {
        return BATTERY;
    }

    public int getRAM() {
        return RAM;
    }

    public String getCOLOUR() {
        return COLOUR;
    }
}
