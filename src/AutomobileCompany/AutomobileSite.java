package AutomobileCompany;

import java.text.NumberFormat;

public class AutomobileSite {
    public static void main(String[] args) {
        ProcessTransaction();
    }

    // Method prints welcome message
    static void WelcomeMessage(){
        String message = "\nWelcome to MyAutomobile.com\n" +
                "\n" +
                "To proceed, Enter\n" +
                "1 => Bicycle\n" +
                "2 => Motorbike\n" +
                "3 => Tricycle\n" +
                "4 => Car\n" +
                "5 => Jeep\n" +
                "6 => Truck\n" +
                "7 => Help/Support\n" +
                "0 => Exit\n";

        System.out.println(message);
    }

    // Method prints goodbye message
    static void GoodbyeMessage(){
        String message = "\nThank you for visiting MyAutomobile.com";
        System.out.println(message);
    }

    // Method processes payment
    static void ProcessPayment(String paymentMode) {
        switch (paymentMode) {
            case "Card" -> GetData.GetUserPin();
            case "Cash" -> System.out.println("\nKindly pay on the counter\nThanks\n");
            case "Installments" -> System.out.println("\nTransaction Successful\n");
        }
    }

    // Method processes transaction
    public static void ProcessTransaction(){

        double grossPrice; double netPrice; float discountRate; float interestRate = 0; String automobileType;

        int[] stockList = {50, 50, 50, 50, 50, 50};

        do {
            WelcomeMessage();

            automobileType = PromptUser.Automobiles();

            if (automobileType.equals("Exit"))
                break;
            else {

                double priceOfAutomobile = GetData.GetPriceOfAutomobile(automobileType);
                System.out.println("Price: " + NumberFormat.getCurrencyInstance().format(priceOfAutomobile));

                int quantityOfAutomobile = PromptUser.GetQuantityOfAutomobile();
                boolean quantityAvailable = GetData.CheckStock(stockList, automobileType, quantityOfAutomobile);

                if (quantityAvailable) {
                    grossPrice = priceOfAutomobile * quantityOfAutomobile;
                    System.out.println("Gross Price: " + NumberFormat.getCurrencyInstance().format(grossPrice));

                    discountRate = GetData.GetDiscountRate(quantityOfAutomobile);
                    System.out.println("Discount Rate: " + NumberFormat.getPercentInstance().format(discountRate));

                    netPrice = grossPrice - (grossPrice * discountRate);
                    System.out.println("Net Price: " + NumberFormat.getCurrencyInstance().format(netPrice));

                    String modeOfPayment = GetData.GetModeOfPayment();

                    String periodOfInstallment = "";
                    double totalInstallments = 0;
                    double monthlyInstallment = 0;

                    if (modeOfPayment.equals("Installments")) {
                        periodOfInstallment = GetData.GetDurationOfInstallment();
                        interestRate = GetData.GetInterestRate(periodOfInstallment);
                        totalInstallments = Calculate.CalculateTotalInstallmentPayment(netPrice, interestRate);
                        monthlyInstallment = Calculate.CalculateMonthlyInstallment(periodOfInstallment, totalInstallments);
                    }

                    ProcessPayment(modeOfPayment);

                    String transactionDetails = "";

                    switch (modeOfPayment) {
                        case "Card", "Cash" -> transactionDetails = "\n-------------------------\n" +
                                "Transaction Detail\n" +
                                "-------------------------\n" +
                                "Mode Of Payment: " + modeOfPayment + "\n" +
                                "Automobile: " + automobileType + "\n" +
                                "Price: " + NumberFormat.getCurrencyInstance().format(priceOfAutomobile) + "\n" +
                                "Quantity: " + quantityOfAutomobile + "\n" +
                                "Discount Rate: " + NumberFormat.getPercentInstance().format(discountRate) + "\n" +
                                "Gross Price: " + NumberFormat.getCurrencyInstance().format(grossPrice) + "\n" +
                                "Net Total: " + NumberFormat.getCurrencyInstance().format(netPrice) + "\n" +
                                "-------------------------\n";
                        case "Installments" -> transactionDetails = "\n-------------------------\n" +
                                "Transaction Detail\n" +
                                "-------------------------\n" +
                                "Mode Of Payment: " + modeOfPayment + "\n" +
                                "Automobile: " + automobileType + "\n" +
                                "Price: " + NumberFormat.getCurrencyInstance().format(priceOfAutomobile) + "\n" +
                                "Quantity: " + quantityOfAutomobile + "\n" +
                                "Discount Rate: " + NumberFormat.getPercentInstance().format(discountRate) + "\n" +
                                "Gross Price: " + NumberFormat.getCurrencyInstance().format(grossPrice) + "\n" +
                                "Net Total: " + NumberFormat.getCurrencyInstance().format(netPrice) + "\n" +
                                "Period Of Installment: " + periodOfInstallment + "\n" +
                                "Interest Rate: " + NumberFormat.getPercentInstance().format(interestRate) + "\n" +
                                "Monthly Payment: " + NumberFormat.getCurrencyInstance().format(monthlyInstallment) + "\n" +
                                "Total Installment Payment: " + NumberFormat.getCurrencyInstance().format(totalInstallments) + "\n" +
                                "-------------------------\n";
                    }

                    System.out.println(transactionDetails);
                    break;

                } else {
                    System.out.println("Current stock is less than quantity demanded");
                }
            }

        } while (true);

        GoodbyeMessage();
    }
}




















