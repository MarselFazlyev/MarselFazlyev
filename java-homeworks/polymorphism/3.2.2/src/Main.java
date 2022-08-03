import TaxType.*;

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[4];
        payments[0]= new Bill(10000.0,new IncomeTaxType(),new TaxService());
        payments[1]= new Bill(99999.99,new ProgressiveTaxType(),new TaxService());
        payments[2]= new Bill(100000.0,new ProgressiveTaxType(),new TaxService());
        payments[3]= new Bill(50000.00,new VATaxType(),new TaxService());

        for (int i= 0; i<payments.length; i++ ) {
            Bill bill = payments[i];
            bill.payTaxes();
        }









    }
}
