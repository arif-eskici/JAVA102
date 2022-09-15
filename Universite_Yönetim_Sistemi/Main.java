package Universite_Yönetim_Sistemi;

public class Main {
    public static void main(String[] args) {
        Calisan calisan = new Calisan("Arif Eskici", "0555 123 12 12", "patika@patika.dev");
        System.out.println(calisan.getAdSoyad());
        System.out.println("**********************");

        Akademisyen akademisyen = new Akademisyen("Mahmut Hoca", "0555 123 11 22", "mahmut@hoca.com", "Tarih", "Prof.");
        System.out.println("Öğretim Elemanı : "+akademisyen.getAdSoyad()+ " ,\tGireceği Ders : "+akademisyen.getBolum());
        System.out.println("***********************");
        akademisyen.derseGir();
        akademisyen.yemekhane();
        akademisyen.cikis();
        System.out.println("***********************");

        LabAsistani labAsistani = new LabAsistani("İnek Şaban", "0555 111 44 77", "şaban@patika.dev", "Hababam Sınıfı", "Asistan", "Saat ücretli");
        System.out.println(labAsistani.getAdSoyad()+" laboratuar derslerini takip ediyor.");
        System.out.println("***********************");
        labAsistani.lablaraGir();
        labAsistani.derseGir();
        labAsistani.cikis();
        System.out.println("***********************");

    }
}
