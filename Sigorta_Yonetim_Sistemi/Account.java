package Sigorta_Yonetim_Sistemi;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements Comparable<Account> {
    protected Scanner scanner = new Scanner (System.in);
    private User user;
    private ArrayList<Individual> individualList;
    private AuthenticationStatus status = AuthenticationStatus.FAIL;

    enum AuthenticationStatus {
        FAIL,
        SUCCESS;
    }

    public Account (User user) {
        this.user = user;
    }

    public void addAddress(){
        AddressManager.addAddress(this.user);
    }

    public void deleteAddress(){
        printAddresses();
        System.out.print("Silmek istediğiniz adresin id numarasını yazın : ");
        int id = scanner.nextInt();
        AddressManager.deleteAddress(user,id);
    }

    private void printAddresses() {
        for (Address address : user.getAddressList()){
            address.showAddressInfo();
        }
    }

    public void login (String email, String password, Account account) throws Exception {
        if(account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password)){
            status=AuthenticationStatus.SUCCESS;
        }
        else throw new Exception("Giriş işlemi başarısız.");
    }

    public final void showUserInfo(){
        System.out.println("Kullanıcı adı soyadı : " +user.getName()+ " " +user.getSurname()+
                           "\nE-mail : " +user.getEmail()+ 
                           "\nMeslek : " +user.getJob()+
                           "\nYaş : " + user.getAge()+
                           "\nSon giriş tarihi : " + user.getLastEntry()+
                           "\nÜyelik türü : "+user.getMembership());
        printInsurances();
        printAddresses();
    }

    private void printInsurances() {
        for(Insurance insurance: user.getInsuranceList()){
            System.out.println("Sigorta Türü : " +insurance.getName()+ ", Ücreti : " + insurance.getPrice()+
                               ", Başlangıç Tarihi : " +insurance.getStartDate()+ ", Bitiş Tarihi : " + insurance.getFinishDate());
        }
    }

    public abstract void addPolicy();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
