package Sigorta_Yonetim_Sistemi;

import java.util.Date;

public class Travel_insurance extends Insurance {

    public Travel_insurance(String insuranceType) {
        super("Seyahat Sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 999.99;
        if(insuranceType.equals("Individual")) {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")) {
            setPrice(price*0.9);
        }
        
    }
    
}
