package PatikaStore;

import java.util.ArrayList;

public class MobilePhone extends Product {

    private static int pId = 1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> phones = new ArrayList<>();

    public MobilePhone() {}

    public MobilePhone (String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram,
                        int memory, int battery, String color, int camResolution) {
        super(pId, name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery=battery;
        this.color=color;
        this.camResolution=camResolution;
    }

    @Override
    public void menu() {
        System.out.println("1- Yeni Telefon ekle\n" +
                           "2- Telefon listesini görüntüle\n" +
                           "3- Telefon sil\n" +
                           "4- Telefonları id numarasına göre sırala\n" +
                           "5- Telefonları markaya göre filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value = input.nextInt();
        if(value == 1) addItem();
        if(value == 2 || value == 4) getProducts();
        if(value == 3) deleteItem();
        if(value == 5) brandFilter();
    }

   
    @Override
    public void addItem() {
        System.out.print("Ürünün fiyatı : ");
        double price = input.nextDouble();

        System.out.print("Ürünün adı : ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Ürünün indirim oranı : ");
        int discountRate = input.nextInt();

        System.out.print("Ürünün stoğu : ");
        int amount = input.nextInt();

        System.out.print("Ürünün rami : ");
        int ram = input.nextInt();

        System.out.print("Ürünün ekranı : ");
        double screenSize = input.nextDouble();

        System.out.print("Ürünün hafızası :");
        int memory = input.nextInt();
        
        System.out.print("Ürünün pili : ");
        int battery = input.nextInt();
        input.nextLine();

        System.out.print("Ürünün rengi : ");
        String color = input.nextLine();

        System.out.print("Kamera çözünürlüğü : ");
        int camResolution = input.nextInt();
        
        Brand.printBrands();
        System.out.print("Marka Seçiniz : ");
        Brand brand = Brand.getBrand(input.nextInt());
        MobilePhone phone = new MobilePhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Eklenen telefonun id'si : " +phone.getId());
    }

    @Override
    public void getProducts() {
        print(null);
        
    }

    private void print(ArrayList<MobilePhone> phoneList) {
        if (phoneList == null) phoneList = this.phones;
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyat         | Marka           | Stok         | RAM         | Ekran       | Hafıza      | Batarya     | Çözünürlük    |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n : phoneList){
            System.out.printf("| %-2s | %-25s | %-13s | %-15s | %-12s | %-11s | %-11s | %-11s | %-11s | %-13s |\n",
                                n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                                n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getCamResolution());
        }
    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediğiniz telefonun Id numarasını giriniz : ");
        int id = input.nextInt();
        phones.remove(id-1);
        System.out.println("Güncel telefon listesi ");
        getProducts();
    }
    
    private void brandFilter() {
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = input.nextLine();
        ArrayList<MobilePhone> filterPhones = new ArrayList<>();
        for (MobilePhone n : phones){
            if (filter.equals(n.getBrand().getName())){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }

    public static int getpId() {
        return pId;
    }

    
}
