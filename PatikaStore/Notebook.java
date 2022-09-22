package PatikaStore;

import java.util.ArrayList;

public class Notebook extends Product {
    private static int nId = 1;
    private static ArrayList <Notebook> notebooks = new ArrayList<>();

    public Notebook(String name, double price, int discountRate, int amount, Brand brand, double screenSize,
            int ram, int memory) {
        super(nId, name, price, discountRate, amount, brand, screenSize, ram, memory);
        nId++;
    }

    public Notebook (){}


    @Override
    public void menu() {
        System.out.println("1- Yeni Notebook ekle\n" +
                           "2- Notebook listesini görüntüle\n" +
                           "3- Notebook sil\n" +
                           "4- Notebookları id numaralarına göre sırala\n" +
                           "5- Notebookları markaya göre filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value = input.nextInt();
        if (value == 1) addItem();
        if (value == 2 || value == 4) getProducts();
        if (value == 3) deleteItem();
        if (value == 5) brandFilter();
        
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

       System.out.print("Ürünün hafızası : ");
       int memory = input.nextInt();

       Brand.printBrands();
       System.out.print("Marka Seçiniz : ");
       Brand brand = Brand.getBrand(input.nextInt());
       Notebook notebook = new Notebook(name,price,discountRate,amount,brand,screenSize,ram,memory);
       this.notebooks.add(notebook);
       System.out.println("Eklenen Notebook id'si : " +notebook.getId());
    }


    @Override
    public void getProducts() {
        print(null);
    }


    public void print(ArrayList<Notebook> notebookList) {
        if (notebookList == null) {
            notebookList = this.notebooks;
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyat         | Marka           | Stok         | İndirim (%)     | RAM        | Ekran      | Hafıza     |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n: notebookList) {
            System.out.printf("| %-2s | %-25s | %-13s | %-15s | %-12s | %-15s | %-10s | %-10s | %-10s |  \n",
                            n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                            n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }

    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediğiniz Notebook'un id numarasını giriniz : ");
        int id = input.nextInt();
        notebooks.remove(id-1);
        System.out.println("Güncel Notebook listesi ");
        getProducts();
        
    }

    private void brandFilter() {
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = input.nextLine();
        ArrayList<Notebook> filterNotebooks = new ArrayList<>();
        for (Notebook n : notebooks){
            if(filter.equals(n.getBrand().getName())){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    public static int getnId() {
        return nId;
    }    
}
