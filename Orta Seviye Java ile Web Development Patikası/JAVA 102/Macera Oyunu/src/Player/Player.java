package Player;

import Characters.Monsters;
import Characters.Warriors;
import Locations.Armor;
import Locations.SafeHouse;
import Locations.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Player {


private String character;
private String monster;
private String location;
private boolean answer=false;
private int intAnswer;
private String charAnswer;
protected String weapon;
protected String armor;
protected boolean bWeapon;
protected boolean bArmor;
private int numberOfMonsters;
private boolean bRiver;
private boolean bForest;
private boolean bCave;
private boolean bMine;




private final Scanner scan= new Scanner(System.in);

private final Random rdm = new Random();

private Inventory inventory= new Inventory();


    SafeHouse safeHouse= new SafeHouse();


    Warriors samurai= new Warriors("Samuray",1,0,5,21,15);

    Warriors archer= new Warriors("Okçu",2,0,7,18,20);

    Warriors knight= new Warriors("Şövalye",3,0,8,24,5);



    Monsters zombie = new Monsters("Zombi", 1, 3, 10, 4);

    Monsters vampire = new Monsters("Vampir", 2, 4, 14, 7);

    Monsters bear = new Monsters("Ayı", 3, 7, 20, 12);

    Monsters snake =new Monsters("Yılan",4, rdm.nextInt(3,7),12,0);



    Armor lightArmor= new Armor("Hafif Zırh",1,1,15);

    Armor mediumArmor= new Armor("Orta Zırh",2,3,25);

    Armor heavyArmor= new Armor("Ağır Zırh",3,5,40);



    Weapon pistol= new Weapon("Tabanca",1,2,25);

    Weapon sword= new Weapon("Kılıç",2,3,35);

    Weapon rifle=new Weapon("Tüfek",3,7,45);



    public Weapon returnWeapon() {

        if (this.weapon.equals("Tabanca")) {

            return pistol;

        }else if (this.weapon.equals("Kılıç")) {

            return sword;

        }else {

            return rifle;
        }

    }



    public Armor returnArmor() {

        if (this.armor.equals("Hafif Zırh")) {

            return lightArmor;

        }else if (this.armor.equals("Orta Zırh")) {

            return mediumArmor;

        }else {

            return heavyArmor;
        }

    }



    public Monsters returnMonster() {

        if (this.monster.equals("Zombi")) {

            return zombie;


        }else if (this.monster.equals("Vampir")) {

            return vampire;

        }else if (this.monster.equals("Ayı")) {

            return vampire;

        } else return snake;

    }



    public Warriors returnWarrior() {

        if (this.character.equals("Samuray")) {

            return samurai;


        }else if (this.character.equals("Okçu")) {

            return archer;

        }else {

            return knight;
        }

    }



    public void selectCharacter() {

        System.out.println ("-----------------------------");

        System.out.println ("Savaşçıların özellikleri: ");

        samurai.printWarrior();
        archer.printWarrior();
        knight.printWarrior();

        System.out.println ("-----------------------------");


        System.out.print("Lütfen seçmek istediğiniz karakterin numarasını yazınız: ");

    do{

            intAnswer=scan.nextInt();
            if (intAnswer>0 && intAnswer<4) {



            switch (intAnswer) {

                case 1:
                    character="Samuray";
                    System.out.println(character+" karakteri seçildi.");
                    System.out.println ("Savaşçı özellikleri: ");
                    samurai.printWarrior();
                    answer=true;

                    break;

                case 2:
                    character="Okçu";
                    System.out.println(character+" karakteri seçildi.");
                    System.out.println ("Savaşçı özellikleri: ");
                    archer.printWarrior();
                    answer=true;
                    break;

                case 3:
                    character="Şövalye";
                    System.out.println(character+" karakteri seçildi.");
                    System.out.println ("Savaşçı özellikleri: ");
                    knight.printWarrior();
                    answer=true;
                    break;

                default: System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");

            }

            } else System.out.println ("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");



            }while(!answer);


}


    public void selectLocation() {

        boolean game= true;

        System.out.println();



        do {


            System.out.println ("-----------------------------");


            System.out.println ("Lokasyonlar");

            System.out.println("""
                    1. Nehir
                    2. Orman
                    3. Mağara
                    4. Maden
                    5. Güvenli Ev
                    6. Silah Ve Zırh Mağazası
                    7. Oyundan Çıkış Yap
                    """);

            System.out.println ("-----------------------------");


            System.out.print ("Lütfen gitmek istediğiniz lokasyonun numarasını yazınız: ");


            intAnswer = scan.nextInt();

            if (intAnswer>0 && intAnswer<8) {

                switch (intAnswer) {

                    case 1:
                        if (!bRiver) {


                            location = "Nehir";
                            monster = "Zombi";
                            this.numberOfMonsters = zombie.makeMonsterNumber();
                            System.out.println(location + " lokasyonu seçildi.");
                            System.out.println("Canavar özellikleri: ");
                            zombie.printMonster();
                            System.out.println(zombie.getName() + " adedi: " + this.numberOfMonsters);
                            System.out.println("Lokasyon Eşyası: " + inventory.getGoods(this.location));
                            if (battle()) {
                                inventory.setbWater(true);
                                bRiver = true;

                                if (foodControl() && bMine) {

                                    System.out.println("Tüm eşyalar toplanmıştır. Oyun kazanılmıştır. Tebrik ederim!");
                                    System.out.println ("Güvenli Eve dönüş gerçekleştirirseniz oyunu başarılı bir şekilde sonlandıracaksınız.");
                                    break;


                                } else System.out.println ("Oyunu kazanmak için tüm eşyaları kazanmalısınız. Cesaret dilerim!");
                            } else game=false;

                        } else {
                            System.out.println("Bu lokasyonundaki canavarlar daha önce yok edildiğinden dolayı giriş yapamamaktasınız. Başka bir loksayonu deneyininiz.");
                        }

                        break;

                    case 2:

                        if (!bForest) {
                            location = "Orman";
                            monster = "Vampir";
                            this.numberOfMonsters = vampire.makeMonsterNumber();
                            System.out.println(location + " lokasyonu seçildi.");
                            System.out.println("Canavar özellikleri: ");
                            vampire.printMonster();
                            System.out.println(vampire.getName() + " adedi: " + this.numberOfMonsters);
                            System.out.println("Lokasyon Eşyası: " + inventory.getGoods(this.location));
                            if (battle()) {
                                bForest = true;
                                inventory.setbFirewood(true);

                                if (foodControl() && bMine) {

                                    System.out.println("Tüm eşyalar toplanmıştır. Oyun kazanılmıştır. Tebrik ederim!");
                                    System.out.println ("Güvenli Eve dönüş gerçekleştirirseniz oyunu başarılı bir şekilde sonlandıracaksınız.");
                                    break;


                                } else System.out.println ("Oyunu kazanmak için tüm eşyaları kazanmalısınız. Cesaret dilerim!");
                            } else game=false;

                        } else {
                            System.out.println("Bu lokasyonundaki canavarlar daha önce yok edildiğinden dolayı giriş yapamamaktasınız. Başka bir loksayonu deneyininiz.");
                        }

                        break;

                    case 3:
                        if (!bCave) {

                            location = "Mağara";
                            monster = "Ayı";
                            this.numberOfMonsters = bear.makeMonsterNumber();
                            System.out.println(location + " lokasyonu seçildi.");
                            System.out.println("Canavar özellikleri: ");
                            bear.printMonster();
                            System.out.println(bear.getName() + " adedi: " + this.numberOfMonsters);
                            System.out.println("Lokasyon Eşyası: " + inventory.getGoods(this.location));

                            if (battle()) {
                                inventory.setbFood(true);
                                bCave = true;

                                if (foodControl() && bMine) {

                                    System.out.println("Tüm eşyalar toplanmıştır. Oyun kazanılmıştır. Tebrik ederim!");
                                    System.out.println ("Güvenli Eve dönüş gerçekleştirirseniz oyunu başarılı bir şekilde sonlandıracaksınız.");
                                    break;


                                } else System.out.println ("Oyunu kazanmak için tüm eşyaları kazanmalısınız. Cesaret dilerim!");
                            } else game=false;
                        } else {
                            System.out.println("Bu lokasyonundaki canavarlar daha önce yok edildiğinden dolayı giriş yapamamaktasınız. Başka bir loksayonu deneyininiz.");

                        }
                        break;


                    case 4:
                        if (!bMine) {

                            location = "Maden";
                            monster = "Yılan";
                            this.numberOfMonsters = rdm.nextInt(1,6);
                            System.out.println(location + " lokasyonu seçildi.");
                            System.out.println("Canavar özellikleri: ");
                            snake.printMonster();
                            System.out.println(snake.getName() + " adedi: " + this.numberOfMonsters);
                            System.out.println("Lokasyon Eşyası: Silah, Zırh, Para");

                            if (battle()) {
                                bMine = true;

                                inventory.chanceStuff();

                                if (foodControl() && bMine) {

                                    System.out.println("Tüm eşyalar toplanmıştır. Oyun kazanılmıştır. Tebrik ederim!");
                                    System.out.println ("Güvenli Eve dönüş gerçekleştirirseniz oyunu başarılı bir şekilde sonlandıracaksınız.");
                                    break;

                                } else System.out.println ("Oyunu kazanmak için tüm eşyaları kazanmalısınız. Cesaret dilerim!");
                            } else game=false;
                        } else {
                            System.out.println("Bu lokasyonundaki canavarlar daha önce yok edildiğinden dolayı giriş yapamamaktasınız. Başka bir loksayonu deneyininiz.");

                        }
                        break;



                    case 5:

                        if (foodControl()) {

                            System.out.println ("Macera Oyununu oynadığınız için teşekkürler. Tekrar görüşmek dileğiyle.");
                            game=false;
                            break;
                        }

                        if (safeHouse.getSpareLife() > 0) {

                            location = "Güvenli Ev";
                            System.out.println(location + " lokasyonu seçildi.");

                            returnWarrior().setHealth(safeHouse.fullHealth(returnWarrior().getName(), returnWarrior().getHealth()));


                        } else {
                            System.out.println("Yedek canınız tükendiğinden dolayı Güvenli Ev'e girişiniz reddedilmiştir.");
                        }
                        break;


                    case 6:

                        System.out.println ("-----------------------------");


                        location = "Silah Ve Zırh Mağazası";
                        System.out.println(location + " lokasyonu seçildi.");
                        System.out.println("Silah Seçenekleri: ");
                        pistol.printWeapon(pistol);
                        sword.printWeapon(sword);
                        rifle.printWeapon(rifle);

                        System.out.println ("-----------------------------");


                        System.out.println("Zırh Seçenekleri: ");
                        lightArmor.printArmor(lightArmor);
                        mediumArmor.printArmor(mediumArmor);
                        heavyArmor.printArmor(heavyArmor);

                        System.out.println ("-----------------------------");


                        System.out.println("Silah ya da zırh satın almak ister misiniz: E/h");
                        charAnswer = scan.next();

                        while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                            System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                            charAnswer = scan.next();
                        }

                            buyWeaponOrArmor(charAnswer);

                        break;

                    case 7:
                        System.out.println ("Oyundan çıkış yaptınız.");
                        game=false;
                        break;


                    default:
                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                }

            } else
                System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");

        } while (game);

    }


    public void buyWeaponOrArmor (String answer) {

        int buy;

        if (answer.equals("E")) {

            if (returnWarrior().getMoney() > 15) {

                System.out.println ("-----------------------------");


                System.out.println("""
                        1. Tabanca
                        2. Kılıç
                        3. Tüfek
                        4. Hafif Zırh
                        5. Orta Zırh
                        6. Ağır Zırh""");

                System.out.println ("-----------------------------");

                System.out.print("Satın almak istediğiniz silah ya da zırhın numarasını giriniz: ");


                buy = scan.nextInt();


                while (buy<0 || buy>6) {

                    System.out.println ("Yanlış bir tuşlama yaptınız. Tekrar deneyiniz.");
                    buy = scan.nextInt();

                }


                    switch (buy) {


                        case 1:

                            if (bArmor) {
                                System.out.println ("Zırhınız bulunduğundan dolayı silah satın alamazsınız.");
                            } else {


                                if (returnWarrior().getMoney() == pistol.getMoney() || returnWarrior().getMoney() > pistol.getMoney()) {
                                    weapon = "Tabanca";
                                    bWeapon = true;
                                    System.out.println("Satın alınan silah: " + weapon);
                                    System.out.println("Harcanan Para: " + returnWeapon().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnWeapon().getMoney());
                                    returnWarrior().setDamage(returnWarrior().getDamage()+returnWeapon().getDamage());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();

                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }

                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;


                        case 2:

                            if (bArmor) {
                                System.out.println("Zırhınız bulunduğundan dolayı silah satın alamazsınız.");
                            } else {


                                if (returnWarrior().getMoney() == sword.getMoney() || returnWarrior().getMoney() > sword.getMoney()) {
                                    weapon = "Kılıç";
                                    bWeapon = true;
                                    System.out.println("Satın alınan silah: " + weapon);
                                    System.out.println("Harcanan Para: " + returnWeapon().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnWeapon().getMoney());
                                    returnWarrior().setDamage(returnWarrior().getDamage()+returnWeapon().getDamage());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();

                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }


                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;

                        case 3:


                            if (bArmor) {
                                System.out.println ("Zırhınız bulunduğundan dolayı silah satın alamazsınız.");
                            } else {

                                if ((returnWarrior().getMoney() == rifle.getMoney() || returnWarrior().getMoney() > rifle.getMoney())) {
                                    weapon = "Tüfek";
                                    bWeapon = true;
                                    System.out.println("Satın alınan silah: " + weapon);
                                    System.out.println("Harcanan Para: " + returnWeapon().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnWeapon().getMoney());
                                    returnWarrior().setDamage(returnWarrior().getDamage()+returnWeapon().getDamage());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();

                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }

                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;


                        case 4:
                            if (bWeapon) {
                                System.out.println ("Silahınız bulunduğundan dolayı zırh satın alamazsınız.");
                            } else {

                                if (returnWarrior().getMoney() == lightArmor.getMoney() || returnWarrior().getMoney() > lightArmor.getMoney()) {
                                    armor = "Hafif Zırh";
                                    bArmor = true;
                                    System.out.println("Satın alınan zırh: " + armor);
                                    System.out.println("Harcanan Para: " + returnArmor().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnArmor().getMoney());
                                    returnWarrior().setBlocking(returnArmor().getBlocking());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();
                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }


                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;


                        case 5:

                            if (bWeapon) {
                                System.out.println ("Silahınız bulunduğundan dolayı zırh satın alamazsınız.");
                            } else {

                                if (returnWarrior().getMoney() == mediumArmor.getMoney() || returnWarrior().getMoney() > mediumArmor.getMoney()) {
                                    armor = "Orta Zırh";
                                    bArmor = true;
                                    System.out.println("Satın alınan zırh: " + armor);
                                    System.out.println("Harcanan Para: " + returnArmor().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnArmor().getMoney());
                                    returnWarrior().setBlocking(returnArmor().getBlocking());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();
                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }

                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;

                        case 6:

                            if (bWeapon) {
                                System.out.println ("Silahınız bulunduğundan dolayı zırh satın alamazsınız.");
                            } else {


                                if (returnWarrior().getMoney() == heavyArmor.getMoney() || returnWarrior().getMoney() > heavyArmor.getMoney()) {

                                    armor = "Ağır Zırh";
                                    bArmor = true;
                                    System.out.println("Satın alınan zırh: " + armor);
                                    System.out.println("Harcanan Para: " + returnArmor().getMoney());
                                    returnWarrior().setMoney(returnWarrior().getMoney()- returnArmor().getMoney());
                                    returnWarrior().setBlocking(returnArmor().getBlocking());
                                    System.out.println ("Karakterin güncel durumu: ");
                                    returnWarrior().printWarrior();
                                    System.out.println("Başka bir ürün almak iter misiniz: E/h");
                                    charAnswer = scan.next();

                                    while (!charAnswer.equals("E") && !charAnswer.equals("h")) {

                                        System.out.println("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");
                                        charAnswer = scan.next();
                                    }

                                    buyWeaponOrArmor(charAnswer);
                                    break;

                                } else {

                                    System.out.println("Yeterli paranız bulunmadığı için satın alma işlemi gerçekleşmemiştir.");
                                    break;
                                }

                            }
                            break;

                        default: System.out.println ("Geçersiz bir tuşlama yaptınız. Tekrar deneyiniz.");

                    }




            } else {
                System.out.println("Herhangi bir silah ya da zırhın ücretini karşılayabilecek paranız bulunmamaktadır." + "Silah ve zırh mağazasına uğradığınız için teşekkürler.");
            }


        } else {

            System.out.println("Silah ve zırh mağazasına uğradığınız için teşekkürler. Güle güle!");
        }



    }


    public boolean battle() {


            int i =1;

            Random rdm = new Random();

            int chance=rdm.nextInt(0,101);



            if (chance<=50) {
                //Firs hit from character
                System.out.println ("İlk Vuruş: "+this.character);

                do {

                    System.out.println(i + ". Tur:");

                    i++;

                    if (bWeapon) {


                        returnMonster().setHealth(returnMonster().getHealth() - ((returnWarrior().getDamage() + returnWeapon().getDamage())));


                    } else {

                        returnMonster().setHealth(returnMonster().getHealth() - returnWarrior().getDamage());

                    }


                    if (returnMonster().getHealth()<=0) {

                        System.out.println ("Canavarın Sağlık Durumu: 0");
                        this.numberOfMonsters--;


                    } else {
                        System.out.println ("Canavarın Sağlık Durumu: "+returnMonster().getHealth());
                    }



                    if (returnMonster().getHealth()<=0) {


                        if(this.numberOfMonsters>0) {

                            returnMonster().setHealth(zombie.fullMonsterHealth(this.monster));

                            System.out.println(returnMonster().getName() + " yenildi. " + this.location + " lokasyounda kalan canavar adedi: " + this.numberOfMonsters);


                        } else {

                            System.out.println(returnMonster().getName() + " yenildi. " + this.location + " lokasyounda kalan canavar adedi: " + this.numberOfMonsters);
                            System.out.println ("Karakterin Sağlık Durumu: "+returnWarrior().getHealth());
                            if (location.equals("Maden")) {
                                inventory.chanceStuff();
                            } else {
                            System.out.println ("Kazanılan eşya: "+inventory.getGoods(this.location));
                            System.out.println ("Kazanılan para: "+returnMonster().getMoney());
                            returnWarrior().setMoney(returnWarrior().getMoney()+returnMonster().getMoney());
                            System.out.println ("Karakterin güncel parası: "+returnWarrior().getMoney());

                            }
                            return true;


                        }

                    } else {

                        if (bArmor) {

                            returnWarrior().setHealth((returnWarrior().getHealth()+returnArmor().getBlocking())-returnMonster().getDamage());

                            if (returnWarrior().getHealth()<=0) {

                                System.out.println ("Karakterin Sağlık Durumu: 0");
                                System.out.println("Karakterin Sağlık Durumu: 0");
                                System.out.println (returnWarrior().getName()+" yenildi.");
                                System.out.println ("Oyunu kaybettiniz!");
                                return false;

                            } else {
                                System.out.println ("Karakterin Sağlık Durumu: "+returnWarrior().getHealth());
                            }


                        } else {

                            returnWarrior().setHealth(returnWarrior().getHealth() - returnMonster().getDamage());

                            if (returnWarrior().getHealth() <=0) {

                                System.out.println("Karakterin Sağlık Durumu: 0");
                                System.out.println (returnWarrior().getName()+" yenildi.");
                                System.out.println ("Oyunu kaybettiniz!");
                                return false;

                            } else {
                                System.out.println("Karakterin Sağlık Durumu: " + returnWarrior().getHealth());
                            }

                        }


                    }


                }while(returnMonster().getHealth()>0 && returnWarrior().getHealth()>0 );





            }else {

                System.out.println ("İlk vuruş: "+this.monster);

                do {

                    //Firs hit from monster

                    System.out.println(i + ". Tur:");

                    i++;


                    if (bArmor) {

                        returnWarrior().setHealth((returnWarrior().getHealth()+returnArmor().getBlocking())-returnMonster().getDamage());

                        if (returnWarrior().getHealth()<=0) {

                            System.out.println ("Karakterin Sağlık Durumu: 0");
                            System.out.println("Karakterin Sağlık Durumu: 0");
                            System.out.println (returnWarrior().getName()+" yenildi.");
                            System.out.println ("Oyunu kaybettiniz!");
                            return false;

                        } else {
                            System.out.println ("Karakterin Sağlık Durumu: "+returnWarrior().getHealth());
                        }


                    } else {

                        returnWarrior().setHealth(returnWarrior().getHealth() - returnMonster().getDamage());

                        if (returnWarrior().getHealth() <=0) {

                            System.out.println("Karakterin Sağlık Durumu: 0");
                            System.out.println (returnWarrior().getName()+" yenildi.");
                            System.out.println ("Oyunu kaybettiniz!");
                            return false;

                        } else {
                            System.out.println("Karakterin Sağlık Durumu: " + returnWarrior().getHealth());
                        }

                    }


                    if (bWeapon) {


                        returnMonster().setHealth(returnMonster().getHealth() - ((returnWarrior().getDamage() + returnWeapon().getDamage())));


                    } else {

                        returnMonster().setHealth(returnMonster().getHealth() - returnWarrior().getDamage());

                    }


                    if (returnMonster().getHealth()<=0) {

                        System.out.println ("Canavarın Sağlık Durumu: 0");
                        this.numberOfMonsters--;


                    } else {
                        System.out.println ("Canavarın Sağlık Durumu: "+returnMonster().getHealth());
                    }


                    if (returnMonster().getHealth()<=0) {


                        if (this.numberOfMonsters>0) {

                            returnMonster().setHealth(zombie.fullMonsterHealth(this.monster));

                            System.out.println(returnMonster().getName() + " yenildi. " + this.location + " lokasyounda kalan canavar adedi: " + this.numberOfMonsters);


                        } else {

                            System.out.println(returnMonster().getName() + " yenildi. " + this.location + " lokasyounda kalan canavar adedi: " + this.numberOfMonsters);
                            System.out.println ("Karakterin Sağlık Durumu: "+returnWarrior().getHealth());

                            if (location.equals("Maden")) {
                                if (inventory.chanceStuff().equals(rifle.getName())) {

                                    returnWarrior().setDamage(returnWarrior().getDamage()+ rifle.getDamage());
                                    bWeapon=true;
                                }else if (inventory.chanceStuff().equals(sword.getName())) {

                                    returnWarrior().setDamage(returnWarrior().getDamage()+ sword.getDamage());
                                    bWeapon=true;

                                }else if (inventory.chanceStuff().equals(pistol.getName())) {

                                    returnWarrior().setDamage(returnWarrior().getDamage()+ pistol.getDamage());
                                    bWeapon=true;
                                } else if (inventory.chanceStuff().equals(lightArmor.getName())) {

                                    returnWarrior().setBlocking(returnWarrior().getBlocking()+ lightArmor.getBlocking());
                                    bArmor=true;

                                } else if (inventory.chanceStuff().equals(mediumArmor.getName())) {

                                    returnWarrior().setBlocking(returnWarrior().getBlocking()+ mediumArmor.getBlocking());
                                    bArmor=true;

                                }else if (inventory.chanceStuff().equals(heavyArmor.getName())) {

                                    returnWarrior().setBlocking(returnWarrior().getBlocking()+ heavyArmor.getBlocking());
                                    bArmor=true;

                                } else if (inventory.chanceStuff().equals("1")) {
                                    returnWarrior().setMoney(returnWarrior().getMoney()+1);

                                }else if (inventory.chanceStuff().equals("5")) {
                                    returnWarrior().setMoney(returnWarrior().getMoney()+5);

                                }else if (inventory.chanceStuff().equals("10")) {
                                    returnWarrior().setMoney(returnWarrior().getMoney()+10);

                                }


                            } else {
                            System.out.println ("Kazanılan eşya: "+inventory.getGoods(this.location));
                            System.out.println ("Kazanılan para: "+returnMonster().getMoney());
                            returnWarrior().setMoney(returnWarrior().getMoney()+returnMonster().getMoney());
                            System.out.println ("Karakterin güncel parası: "+returnWarrior().getMoney());

                            }
                            return true;


                        }

                    }


                }while(returnMonster().getHealth()>0 && returnWarrior().getHealth()>0 );



            }







        return true;



    }


    public boolean foodControl() {

        return inventory.isbWater() && inventory.isbFood() && inventory.isbFirewood();

    }




}
