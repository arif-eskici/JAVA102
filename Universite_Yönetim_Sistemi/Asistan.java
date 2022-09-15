package Universite_Yönetim_Sistemi;

public class Asistan extends Akademisyen {

    String ofisSaati;

    public Asistan(String adSoyad, String telefon, String eposta, String bolum, String unvan, String ofisSaati) {
        super(adSoyad, telefon, eposta, bolum, unvan);
        this.ofisSaati = ofisSaati;
    }

    public String getOfisSaati() {
        return ofisSaati;
    }

    public void setOfisSaati(String ofisSaati) {
        this.ofisSaati = ofisSaati;
    }

    public void quizYap () {
        System.out.println(getAdSoyad()+ " Quiz yapmaya gitti.");
    }
    
}
