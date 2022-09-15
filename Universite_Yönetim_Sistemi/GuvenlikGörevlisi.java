package Universite_Yönetim_Sistemi;

public class GuvenlikGörevlisi extends Memur {

    String belge;

    public GuvenlikGörevlisi(String adSoyad, String telefon, String eposta, String departman, String mesai, String belge) {
        super(adSoyad, telefon, eposta, departman, mesai);
        this.belge = belge;
    }

    public String getBelge() {
        return belge;
    }

    public void setBelge(String belge) {
        this.belge = belge;
    }

    public void nobet () {
        System.out.println("Güvenlik görevlisi : "+getAdSoyad()+ " bu gece nöbete kalacak.");
    }
    
}
