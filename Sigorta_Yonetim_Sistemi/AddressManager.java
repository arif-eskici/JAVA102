package Sigorta_Yonetim_Sistemi;

import java.util.Scanner;

public class AddressManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void addAddress(User user) {
        Address newAddress;
        System.out.println("Yeni adres ekleme alanı");
        System.out.print("1 - Ev adresi \n"+
                         "2 - İş adresi \n"+
                         "Eklemek istediğiniz adres seçimini girin : ");
        int address = scanner.nextInt();

        System.out.print("İl : ");
        String city = scanner.next();
        //scanner.nextLine();
        System.out.print("İlçe : ");
        String district = scanner.next();
        scanner.nextLine();
        System.out.print("Sokak : ");
        String street = scanner.nextLine();

        System.out.print("Detaylı adresi yazınız : ");
        String detailAddress = scanner.nextLine();

        if (address == 1) {
            newAddress = new HomeAddress(city,district,street,detailAddress);
        } else {
            newAddress = new BusinessAddress(city,district,street,detailAddress);
        }

        user.setAddressList(newAddress);
    }

    public static void deleteAddress(User user,int id){
        user.getAddressList().remove(id-1);
        System.out.println("Silme işlemi gerçekleşti.");
    }
}
