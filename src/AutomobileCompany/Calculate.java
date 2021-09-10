package AutomobileCompany;

public class Calculate {
    public static void main(String[] args) {
        // Empty on purpose
    }

    // Method calculates total payment of installment
    static double CalculateTotalInstallmentPayment(double netPrice, float interestRate){
        return netPrice + (netPrice * interestRate);
    }

    // Method calculates monthly installments
    static double CalculateMonthlyInstallment(String periodOfPayment, double totalInstallments){
        double monthlyPayment = 0;

        switch (periodOfPayment) {
            case "3months" -> monthlyPayment = totalInstallments / 3;
            case "6months" -> monthlyPayment = totalInstallments / 6;
            case "12months" -> monthlyPayment = totalInstallments / 12;
        }
        return monthlyPayment;
    }

}
