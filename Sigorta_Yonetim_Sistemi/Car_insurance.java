package Sigorta_Yonetim_Sistemi;

import java.util.Date;

public class Car_insurance extends Insurance {

    public Car_insurance(String insuranceType) {
        super("Araba Sigortası", new Date(), new Date());
        calculate(insuranceType);
    }


    @Override
    public void calculate(String insuranceType) {
       double price = 1599.99;
       if (insuranceType.equals("Individual")) {
        setPrice(price);
       }
       if (insuranceType.equals("Enterprise")) {
        setPrice(price * 0.9);
       }
        
    }
    
}
