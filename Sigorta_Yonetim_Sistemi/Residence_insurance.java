package Sigorta_Yonetim_Sistemi;

import java.time.LocalDateTime;
import java.util.Date;

public class Residence_insurance extends Insurance{

    public Residence_insurance(String insuranceType) {
        super("Konut Sigortası", new Date(), new Date());
        calculate(insuranceType);
    }

    @Override
    public void calculate(String insuranceType) {
        double price = 2999.99;
        if(insuranceType.equals("Individual")) {
            setPrice(price);
        }
        if(insuranceType.equals("Enterprise")) {
            setPrice(price*0.9);
        }
        
    }
    
}
