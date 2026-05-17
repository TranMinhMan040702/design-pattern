package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService(new PaypalMethod());
        orderService.orderProduct();
        
        System.out.println("Client change payment method.");

        orderService.setPaymentService(new MomoMethod());
        orderService.orderProduct();
    }
}

class OrderService {

    private PaymentMethod paymentMethod;

    public OrderService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void orderProduct() {
        System.out.println("Starting order product.");
        paymentMethod.execute();
        System.out.println("Ending order product.");
    }
    
}

interface PaymentMethod {
    void execute();
}

class PaypalMethod implements PaymentMethod {

    @Override
    public void execute() {
        System.out.println("Paymentation ::: Pay Pal");
    }

}

class MomoMethod implements PaymentMethod {

    @Override
    public void execute() {
        System.out.println("Paymentation ::: Momo");
    }
    
}
