package Universite_Yönetim_Sistemi;

public class BilgiIslem extends Memur {

    String görev;

    public BilgiIslem(String adSoyad, String telefon, String eposta, String departman, String mesai, String görev) {
        super(adSoyad, telefon, eposta, departman, mesai);
        this.görev = görev;
    }

    public String getGörev() {
        return görev;
    }

    public void setGörev(String görev) {
        this.görev = görev;
    }

    public void networkKurulum () {
        System.out.println("Bilgi işlem personeli : "+getAdSoyad()+ " network sistem kurulumunu yaptı. ");
    }
    
}
