package Sigorta_Yonetim_Sistemi;

import Sigorta_Yonetim_Sistemi.Car_insurance;
import Sigorta_Yonetim_Sistemi.Health_insurance;
import Sigorta_Yonetim_Sistemi.Residence_insurance;
import Sigorta_Yonetim_Sistemi.Travel_insurance;
import Sigorta_Yonetim_Sistemi.User;

public class Individual extends Account {

    private final String individual = "Individual";

    public Individual(User user) {
        super(user);
    }

    @Override
    public int compareTo(Account o) {
        
        return this.getUser().getName().compareTo(o.getUser().getName());
    }

    @Override
    public void addPolicy() {
        System.out.println("Sigorta Türlerimiz");
        System.out.println("1- Sağlık Sigortası\n" +
                           "2- Konut Sigortası\n" +
                           "3- Seyahat Sigortası\n" +
                           "4- Araba Sigortası");
        System.out.print("Yaptımak istediğiniz sigorta çeşidinin numarasını giriniz : ");

        switch (scanner.nextInt()) {
            case 1: 
                getUser().setInsurance(new Health_insurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
            break;
            case 2 :
                getUser().setInsurance(new Residence_insurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
            break;
            case 3 :
                getUser().setInsurance(new Travel_insurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
            break;
            case 4 :
                getUser().setInsurance(new Car_insurance(individual));
                getUser().setInsuranceList(getUser().getInsurance());
                System.out.println("Sigortanız yapılmıştır.");
            break;
            default:
                System.out.println("Geçersiz veri girdiniz!");
            break;
        }
        
    }

}
