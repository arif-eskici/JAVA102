package Sigorta_Yonetim_Sistemi;

import java.lang.Exception;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {

    TreeSet<Account> users = new TreeSet<>();

    public void addUsers() throws ClassCastException {
        Address address = new HomeAddress("İstanbul", "Kadıköy", "Menekşe Sokak", "Atam sitesi Menekşe sokak Kadıköy İstanbul");
        User user1 = new User("İnek", "Şaban", "inek@saban.com", "123", "öğrenci", 23, address, "Individual");
        Account account = new Individual (user1);

        Address address2 = new HomeAddress("Kütahya", "Merkez", "Taşköprü Caddesi", "Taşköprü caddesi  no 12  Merkez Kütahya");
        User user2 = new User("Güdük", "Necmi", "guduk@necmi.com", "456", "müfettiş", 34, address2, "Enterprise");
        Account account2 = new Enterprise(user2);
        users.add(account);
        users.add(account2);
    }
    
    public Account login (String email, String password) {
        addUsers();
        try {
            for (Account acc : users) {
                if (acc.getUser().getEmail().equals(email) && acc.getUser().getPassword().equals(password)) {
                    acc.login(email, password, acc);
                    return acc;
                }
            }
            throw new Exception("Şifre veya email yanlış girildi!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
