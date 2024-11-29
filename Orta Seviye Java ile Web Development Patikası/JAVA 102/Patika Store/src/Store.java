import java.util.*;

public class Store {

    Scanner scan = new Scanner(System.in);


    List<String> brands= new ArrayList<>();
    List<ListOfCellPhone> phones=new ArrayList<>();
    List<ListOfNotebook> notebooks=new ArrayList<>();

    public void writtenBrands() {

        brands.add("Apple");
        brands.add("Xiaomi");
        brands.add("Huawei");
        brands.add("Monster");
        brands.add("Asus");
        brands.add("Casper");
        brands.add("HP");
        brands.add("Lenovo");
        brands.add("Samsung");


    }

    public void writtenNotebooks() {

        notebooks.add(new ListOfNotebook(UUID.randomUUID().toString(),"HUAWEI Matebook 14",7000.0,"Huawei",512,14.0,16));

        notebooks.add(new ListOfNotebook(UUID.randomUUID().toString(),"LENOVO V14 IGL",3699.0,"Lenovo",2048,15.6,32));

        notebooks.add(new ListOfNotebook(UUID.randomUUID().toString(),"ASUS Tuf Gaming",8199.0,"Asus",2048,15.6,32));

    }

    public void writtenCellPhones() {

        phones.add(new ListOfCellPhone(UUID.randomUUID().toString(),"SAMSUNG GALAXY A51",3199.0,"Samsung",128,6.5,32,4000.0,6,"SİYAH"));

        phones.add(new ListOfCellPhone(UUID.randomUUID().toString(),"iPhone 11 64 GB",7379.0,"Apple",64,6.1,5,3046.0,6,"Mavi"));

        phones.add(new ListOfCellPhone(UUID.randomUUID().toString(),"Redmi Note 10 Pro 8GB",4012.0,"Xiaomi",128,6.5,35,4000.0,12,"Beyaz"));

    }

    public void addBrand(String brand) {

        boolean result=true;

        for(String a: brands ) {

            if (a.equals(brand)) {
                System.out.println ("Bu marka bulunmaktadır.");

                result=false;

                break;
            }

        }

        if (result) {
            brands.add(brand);
            System.out.println (brand+ "markası eklenmiştir");

        }
        brands.sort(Comparator.comparing(String::toString));


    }

    public void removeBrand(String brand) {

        boolean result=true;

        for(String a:brands  ) {

            if (a.equals(brand)) {

                brands.remove(brand);
                System.out.println (brand+ "markası kaldırlmıştır");
                result=false;
                break;
            }

        }

        if (result) {
            System.out.println ("Böyle bir marka bulunamamıştır.");
        }
        brands.sort(Comparator.comparing(String::toString));
    }

    public void addCellPhone() {

        System.out.print ("Name: ");
        String name = scan.nextLine();

        System.out.print ("Price: ");
        double price= scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Brand: ");
        String brand = scan.nextLine();

        System.out.print ("Storing: ");
        int storing = scan.nextInt();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Screen: ");
        double screen = scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Camera: ");
        double camera = scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Battery: ");
        double battery = scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("RAM: ");
        int ram = scan.nextInt();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Colour: ");
        String colour = scan.nextLine();

        String id = UUID.randomUUID().toString();

        phones.add(new ListOfCellPhone(id,name,price,brand,storing,screen,camera,battery,ram,colour));
        phones.sort((Comparator.comparing(ListOfCellPhone::getID)));


    }

    public void addNotebook() {

        System.out.print ("Name: ");
        String name = scan.nextLine();

        System.out.print ("Price: ");
        double price= scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Brand: ");
        String brand = scan.nextLine();

        System.out.print ("Storing: ");
        int storing = scan.nextInt();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("Screen: ");
        double screen = scan.nextDouble();
        scan.nextLine(); // Yeni satır karakterini temizle
        System.out.print ("RAM: ");
        int ram = scan.nextInt();
        scan.nextLine(); // Yeni satır karakterini temizle
        String id = UUID.randomUUID().toString();

        notebooks.add(new ListOfNotebook(id,name,price,brand,storing,screen,ram));
        notebooks.sort((Comparator.comparing(ListOfNotebook::getID)));

    }

    public void removeNotebookProduct() {

        System.out.print ("Silmek istediğiniz ürünün ID'sini giriniz: ");

        String id = scan.nextLine();

        boolean result=true;

        for(ListOfNotebook a: notebooks ) {

            if (a.getID().equals(id)) {

                System.out.println (a.getNAME()+" ürünü silindi");
                notebooks.remove(a);
                result=false;
                break;
            }

        }
        if (result) System.out.println ("Bu ID'de ürün bulunamamıştır.");

        notebooks.sort((Comparator.comparing(ListOfNotebook::getID)));

    }

    public void removeCellPhoneProduct(String id) {

        boolean result =true;
        for(ListOfCellPhone a: phones ) {

            if (a.getID().equals(id)) {

                System.out.println (a.getNAME()+" ürünü silindi");
                phones.remove(a);
                result=false;
                break;

            }

        }
        if (result) System.out.println ("Bu ID'de ürün bulunamamıştır.");

        phones.sort((Comparator.comparing(ListOfCellPhone::getID)));

    }

    public void printAllNotebooks(){

        for(ListOfNotebook a: notebooks ) {

            System.out.println ("|              ID                      |       Ürün Adı   |  Fiyat  |  Marka  | Depolama  |  Ekran  | RAM |");

            System.out.println ("|" +a.getID()+   "|  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | 1"+a.getSTORING()+"  |    "+a.getSCREEN()+"  |   "+a.getRAM()+" |");

        }

    }

    public void printAllCellPhones() {

        for(ListOfCellPhone a: phones ) {

            System.out.println ("|              ID                      |       Ürün Adı        |  Fiyat  |  Marka  | Depolama  |  Ekran  | KAMERA | | ŞARJ | RAM |");

            System.out.println ("| " +a.getID()+   " |  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | 1"+a.getSTORING()+"  |    "+a.getSCREEN()+"  |  "+a.getCAMERA()+"  |  "+a.getBATTERY()+"  |   "+a.getRAM()+" |");

        }

    }

    public void printNotebooksByID() {

        notebooks.sort(Comparator.comparing(ListOfNotebook::getID));

        for(ListOfNotebook a: notebooks ) {

            System.out.println ("|              ID                      |       Ürün Adı   |  Fiyat  |  Marka  | Depolama  |  Ekran  | RAM |");

            System.out.println ("|" +a.getID()+   "|  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | 1"+a.getSTORING()+"  |    "+a.getSCREEN()+"  |   "+a.getRAM()+" |");

        }

    }

    public void printNotebooksByBrand() {

        notebooks.sort(Comparator.comparing(ListOfNotebook::getBRAND));

        for(ListOfNotebook a: notebooks ) {

            System.out.println ("|              ID                      |       Ürün Adı   |  Fiyat  |  Marka  | Depolama  |  Ekran  | RAM |");

            System.out.println ("|" +a.getID()+   "|  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | 1"+a.getSTORING()+"  |    "+a.getSCREEN()+"  |   "+a.getRAM()+" |");

        }

    }

    public void printCellPhonesByID() {

        phones.sort(Comparator.comparing(ListOfCellPhone::getID));


        for(ListOfCellPhone a: phones ) {

                System.out.println ("|" +a.getID()+   "|  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | "+a.getSTORING()+"  |  "+a.getSCREEN()+"  |  "+a.getCAMERA()+"  |  "+a.getBATTERY()+"  | "+a.getRAM()+" |");

        }

    }

    public void printCellPhonesByBrand() {

        phones.sort(Comparator.comparing(ListOfCellPhone::getBRAND));


        for(ListOfCellPhone a: phones ) {

                System.out.println ("|" +a.getID()+   "|  "+a.getNAME()+"   | "+ a.getPRICE()+"  |  "+a.getBRAND()+"  | "+a.getSTORING()+"  |  "+a.getSCREEN()+"  |  "+a.getCAMERA()+"  |  "+a.getBATTERY()+"  | "+a.getRAM()+" |");

        }

    }

    public void run() {

        int chosen;
        boolean outcome=true;

        writtenBrands();
        writtenNotebooks();
        writtenCellPhones();

        do{

        System.out.println ("""
                1 - Notebook İşlemleri
                2 - Cep Telefonu İşlemleri
                3 - Marka İşlemleri
                0 - Çıkış Yap""");

        System.out.print ("Tercihiniz: ");

        try {
            chosen = scan.nextInt();
            scan.nextLine();

            switch (chosen){

                case 1: System.out.println ("""
                    1 - Ürün Ekle
                    2 - Ürün Sil
                    3 - Ürünleri Listele
                    0 - Çıkış Yap""");

                    System.out.print ("Tercihiniz: ");

                    chosen = scan.nextInt();
                    scan.nextLine();

                    switch (chosen) {

                        case 1: addNotebook();
                            break;

                        case 2: removeNotebookProduct();
                            break;

                        case 3: System.out.println ("""
                                1 - ID'ye göre listele
                                2 - Markasına Göre Listele
                                3 - Tüm ürünleri listele
                                0 - Çıkış Yap""");

                            int answer= scan.nextInt();
                            scan.nextLine();

                            switch (answer) {

                                case 1:
                                    printNotebooksByID();
                                    break;


                                case 2: printNotebooksByBrand();
                                    break;

                                case 3:
                                    printAllNotebooks();

                                    break;

                                case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                                    outcome=false;
                                    break;

                                default: System.out.println ("Hatalı seçim gerçekleştirdiniz!");

                            }
                            break;

                        case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                        outcome=false;
                            break;

                        default: System.out.println ("Hatalı seçim gerçekleştirdiniz!");
                    }
                    break;


                case 2: System.out.println ("""
                    1 - Ürün Ekle
                    2 - Ürün Sil
                    3 - Ürünleri Listele
                    0 - Çıkış Yap""");

                    System.out.print ("Tercihiniz: ");

                    chosen = scan.nextInt();
                    scan.nextLine();

                    switch (chosen) {

                        case 1: addCellPhone();
                            break;

                        case 2: System.out.print ("Silmek istediğiniz ürünün ID'sini giriniz: ");

                            String id = scan.nextLine();

                            removeCellPhoneProduct(id);
                            break;

                        case 3: System.out.println ("""
                                1 - ID'ye göre listele
                                2 - Markasına Göre Listele
                                3 - Tüm ürünleri listele
                                0 - Çıkış Yap""");

                            int answer= scan.nextInt();
                            scan.nextLine();

                            switch (answer) {

                                case 1:
                                    printCellPhonesByID();
                                    break;


                                case 2:
                                    printCellPhonesByBrand();
                                    break;

                                case 3:
                                    printAllCellPhones();

                                    break;

                                case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                                outcome=false;
                                    break;

                                default: System.out.println ("Hatalı seçim gerçekleştirdiniz!");



                            }
                            break;

                        case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                        outcome=false;
                            break;

                        default: System.out.println ("Hatalı seçim gerçekleştirdiniz!");

                    }
                    break;


                case 3: System.out.println ("""
                    1 - Marka Ekle
                    2 - Marka Sil
                    3 - Markaları Listele
                    0 - Çıkış Yap""");

                    System.out.print ("Tercihiniz: ");
                    chosen = scan.nextInt();
                    scan.nextLine();

                    String reply;

                    switch (chosen) {


                        case 1: System.out.print ("Markanızı giriniz: ");
                            reply= scan.nextLine();

                            addBrand(reply);
                            break;

                        case 2: System.out.print ("Markanızı giriniz: ");
                            reply= scan.nextLine();
                            removeBrand(reply);
                            break;

                        case 3:
                            brands.sort(Comparator.comparing(String::toString));
                            brands.stream().forEach(i->System.out.println ("- "+i));
                            break;

                        case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                        outcome=false;
                            break;

                        default: System.out.println ("Hatalı seçim gerçekleştirdiniz!");

                    }
                    break;


                case 0: System.out.println ("Çıkış işlemi gerçekleştirildi.");
                outcome=false;
                break;

                default: {
                    System.out.println ("Hatalı seçim gerçekleştirdiniz!");
                    run();

                }
            }

        } catch (Exception e) {
            System.out.println ("Hata: Rakamsal değer girilmedi. Program sonlandı.");

            outcome=false;
        }




    }while(outcome);




}

}
