package AdventureGame;

import java.util.Scanner;

public class Player {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int orjinalHealth;
    private int coin;
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();     // Bunu yaparak null hatasından kurtulduk. Çünkü başka yerden nesne almadığımızdan burada null nesne oluşturuyoruz.
    }


    private Scanner input = new Scanner(System.in);

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {    // Burada bunu yaparak hem silahtan 2 tane almayı hemde başka method kullanmadan direk buradan yapmayı sağladık.
        return this.damage;
    }
    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
           health=0;
        }
        this.health = health;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    Shop shop = new Shop(this);

    public void selectChar() {  // Karakter secme methodu
        boolean isChoose = true;
        while (isChoose) {
            System.out.print("\nSecmek istediginiz karakter ID sini giriniz : ");
            int choose = input.nextInt();
            switch (choose) {
                case 1 -> {
                    initPlayer(new Samurai());
                    isChoose = false;
                    break;
                }
                case 2 -> {
                    initPlayer(new Archer());
                    isChoose = false;
                    break;
                }
                case 3 -> {
                    initPlayer(new Knight());
                    isChoose = false;
                    break;
                }
                default -> System.out.println("Yanlis secim yaptiniz, tekrar seciniz!");
            }

        }

       /* System.out.println(this.name + " isimli karakterinizin ozellikleri\n###############################");
        System.out.println();
        System.out.println("Karakter :\t" + this.getName()
                + "\t\tHasar :\t" + this.getDamage() + "\t\tSağlık :\t"
                + this.getHealth() + "\t\tPara :\t" + this.getCoin());
        System.out.println();

        */
    }

    void initPlayer(GameChar gameChar) {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
    }

    public static void properties(GameChar[] gameChars) {   // Karakter ozellikleri yazdırma methodu.Polymorphism!
        for (GameChar gameChar : gameChars) {
            System.out.println("ID :  " + gameChar.getID() + "\t\tKarakter :  " + gameChar.getName()
                    + ",\t\tHasar :  " + gameChar.getDamage() + ",\tSağlık :  "
                    + gameChar.getHealth() + ",\tPara :  " + gameChar.getCoin());
        }
    }

    public void printcharacter() {
        System.out.println();
        System.out.println(this.name + " isimli karakterinizin özellikleri : ");
        System.out.println("Silah :  " + this.getInventory().getWeapon().getName() + ",\tHasar :  " + this.getTotalDamage()
                + ",\tZırh :  " + this.getInventory().getArmor().getName() + ",\tBloklama :  " + this.getInventory().getArmor().getDodge()
                + ",\tCan :  "
                + this.getHealth() + ",\tPara :  " + this.getCoin());
        System.out.println();
    }
}
