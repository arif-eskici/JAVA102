package PatikaStore;

import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String name;

    public static TreeSet <Brand> brandList = new TreeSet<>(new Comparator<Brand>() {

        @Override
        public int compare(Brand o1, Brand o2) {
            
            return o1.getName().compareTo(o2.getName());
        }
        
    });
    static {
        createBrands();
    }

    public Brand (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void createBrands() {
        brandList.add(new Brand(8, "Samsung"));
        brandList.add(new Brand(6, "Lenovo"));
        brandList.add(new Brand(1, "Apple"));
        brandList.add(new Brand(5, "Huawei"));
        brandList.add(new Brand(3, "Casper"));
        brandList.add(new Brand(2, "Asus"));
        brandList.add(new Brand(4, "HP"));
        brandList.add(new Brand(9, "Xiaomi"));
        brandList.add(new Brand(7, "Monster"));
    }

    public static void printBrands() {
        System.out.println("Markalarımız ");
        System.out.println("--------------------");
        for (Brand brand : brandList) {
            System.out.println(brand.id+ " - " +brand.getName());
        }
        System.out.println("--------------------");
    }

    public static Brand getBrand (int id) {
        for (Brand b : brandList) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }

}
