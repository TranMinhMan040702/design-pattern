package structural.adapter;

public class Main {
    public static void main(String[] args) {

        if (args[0] == null) {
            System.out.println("Chose method payment, pleases..");
        }

        VisaPaymentGate visaPaymentGate = null;
        String type = args[0];

        if ("VISA".equals(type)) {
            visaPaymentGate = new VisaPayment();
        } else if ("MOMO".equals(type)) {
            visaPaymentGate = new MomoPaymentAdapter(new MomoService(), 27000);
        }

        visaPaymentGate.processVisaPayment("MANTM033333", 10);
    }
}

interface VisaPaymentGate {
    void processVisaPayment(String cardNo, double amountInUsd);
}

class VisaPayment implements VisaPaymentGate {

    @Override
    public void processVisaPayment(String cardNum, double amountInUsd) {
        System.out.println("Visa System: Directly charging $" + amountInUsd + " from Visa Card " + cardNum);
    }
    
}

class MomoPaymentAdapter implements VisaPaymentGate {

    private IMomoService momoService;
    private double exchangeRate;

    public MomoPaymentAdapter(IMomoService momoService, double exchangeRate) {
        this.momoService = momoService;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public void processVisaPayment(String cardNo, double amountInUsd) {
        double amountInVnd = amountInUsd * exchangeRate;
        momoService.makeMomoPayment(cardNo, amountInVnd);
    }
    
}
