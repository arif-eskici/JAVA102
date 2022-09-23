package Sigorta_Yonetim_Sistemi;

import java.util.Date;
import java.util.Calendar;

public class Health_insurance extends Insurance {

    public Health_insurance(String insuranceType) {
        super("Sağlık Sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 1099.99;
        if (insuranceType.equals("Individual")) {
            setPrice(price);
        }
        if (insuranceType.equals("Enterprice")) {
            setPrice(price * 0.9);
        }
        
    }
    
}
