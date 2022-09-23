package Sigorta_Yonetim_Sistemi;

public class Enterprise extends Account {

    private final String enterprise = "Enterprise";

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public int compareTo(Account o) {
        
        return this.getUser().getName().compareTo(o.getUser().getSurname());
    }

    @Override
    public void addPolicy() {
        System.out.println("Sigorta Türlerimiz");
        System.out.println("1- Sağlık Sigortası\n" +
                           "2- Konut Sigortası\n" +
                           "3- Seyahat Sigortası\n" +
                           "4- Araba Sigortası");
        System.out.print("Yaptırmak istediğiniz sigorta çeşidinin numarasını giriniz : ");

        switch (scanner.nextInt()) {
            case 1 : 
                if (checkInsurance(new Health_insurance(enterprise))){
                    getUser().setInsurance(new Health_insurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                } else {
                    System.out.println("Bu sigorta sizde mevcut.");
                }
            break;
            case 2 :
                if (checkInsurance(new Residence_insurance(enterprise))){
                    getUser().setInsurance(new Residence_insurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                } else {
                    System.out.println("Bu sigorta sizde mevcut.");
                }
            break;
            case 3 :
                if (checkInsurance(new Travel_insurance(enterprise))){
                    getUser().setInsurance(new Travel_insurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                } else{
                    System.out.println("Bu sigorta sizde mevcut.");
                }  
            break;
            case 4 :
                if (checkInsurance(new Car_insurance(enterprise))){
                    getUser().setInsurance(new Car_insurance(enterprise));
                    getUser().setInsuranceList(getUser().getInsurance());
                    System.out.println("Sigortanız yapılmıştır.");
                } else {  
                    System.out.println("Bu sigorta sizde mevcut.");
                }

            break;
            default:
                System.out.println("Geçersiz veri girdiniz!");
            break;
        }
        
    }

    private boolean checkInsurance(Insurance insurance) {
        for (Insurance i : getUser().getInsuranceList()) {
            if (i.getName().equals(insurance.getName())) {
                return false;
            }
        }
        return true;
    }

}
