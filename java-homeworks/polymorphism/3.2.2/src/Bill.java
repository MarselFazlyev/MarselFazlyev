import TaxType.*;

public class Bill {
    private double amount;
    private TaxType taxtype;
    private TaxService taxService;

    public Bill(double amount, TaxType taxtype, TaxService taxService) {
        this.amount = amount;
        this.taxtype = taxtype;
        this.taxService = taxService;
    }

    public void payTaxes() {
        // TODO: 18.01.2022 посчитать налоги, исходя из TaxType.TaxType
        double taxAmount = taxtype.calculateTaxFor(amount);
        taxService.payOut(taxAmount);
    }
}
