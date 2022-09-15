package Universite_Yönetim_Sistemi;

public class OgretimGörevlisi extends Akademisyen {

    String kapiNo;

    public OgretimGörevlisi(String adSoyad, String telefon, String eposta, String bolum, String unvan, String kapiNo) {
        super(adSoyad, telefon, eposta, bolum, unvan);
        this.kapiNo  =kapiNo;
       
    }

    public String getKapiNo() {
        return kapiNo;
    }

    public void setKapiNo(String kapiNo) {
        this.kapiNo = kapiNo;
    }

    public void senatoToplanti () {
        System.out.println(getAdSoyad() + " senato toplantısına katıldı.");
    }

    public void sinavYap () {
        System.out.println(getAdSoyad()+" sınavını yapmaya gitti.");
    }

    
}
