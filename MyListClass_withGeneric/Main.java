package MyListClass_withGeneric;

public class Main {
    public static void main(String[] args) {
        
        MyList<Integer> list = new MyList<>();

        System.out.println("--------------------------");
        System.out.println("Liste Durumu : " + (list.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("--------------------------");
        System.out.println("Liste Durumu : " + (list.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());

        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(15);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println("--------------------------");
        System.out.println("Liste Durumu : " + (list.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());

        list.add(17);
        list.add(18);
        list.add(19);
        System.out.println("--------------------------");
        System.out.println("2. indisteki değer : " + list.get(2));
        list.remove(2);
        list.add(20);
        list.set(0, 100);
        System.out.println("--------------------------");
        System.out.println("2. indisteki değer : " + list.get(2));
        System.out.println(list.toString());

        System.out.println("--------------------------");
        System.out.println(list.indexOf(25));
        System.out.println(list.indexOf(10));
        System.out.println(list.lastIndexOf(15));
        System.out.println(list.lastIndexOf(115));

        System.out.println("--------------------------");
        Object [] array2 = list.toArray();
        System.out.println(array2[0]);
        System.out.println("Listemde 20 değeri : " + list.contains(20));
        System.out.println("Listemde 120 değeri : " + list.contains(120));
        
        System.out.println("--------------------------");
        list.clear();
        System.out.println(list.toString());
        

    }
}
