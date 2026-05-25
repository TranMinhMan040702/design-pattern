package structural.adapter;

public class MomoService implements IMomoService {

    @Override
    public void makeMomoPayment(String cardNum, double amountInVnd) {
        System.out.println("Momo System: Directly charging $" + amountInVnd + " from Momo Account " + cardNum);
    }
    
}
