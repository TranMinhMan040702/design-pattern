package structural.facade;

public class Main {
    public static void main(String[] args) {
        ShopeeOrderFacade sp = new ShopeeOrderFacade();
        sp.purchaseProduct("Iphone 17 Pro Max");
    }
}

class ShopeeOrderFacade {

    private final InventoryService inventoryService;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final NotificationService notificationService;

    public ShopeeOrderFacade() {
        this.inventoryService = new InventoryService();
        this.productService = new ProductService();
        this.paymentService = new PaymentService();
        this.deliveryService = new DeliveryService();
        this.notificationService = new NotificationService();
    }

    public void purchaseProduct(String productName) {
        inventoryService.check();
        productService.get(productName);
        productService.packProduct();
        paymentService.pay();
        deliveryService.delivery();
        notificationService.sendSms();
    }

}

class InventoryService {
    public void check() {
        System.out.println("Inventory Service ::: Check stock, Products are available.");
    }
}

class ProductService {
    public void get(String name) {
        System.out.println("Product Service ::: Fetching item -> " + name);
    }

    public void packProduct() {
        System.out.println("Product Service ::: Item has been packed.");
    }
}

class PaymentService {
    public void pay() {
        System.out.println("PaymentService ::: Processing payment via PayPal successful.");
    }
}

class DeliveryService {
    public void delivery() {
        System.out.println("Delivery Service ::: Order is out for delivery.");
    }
}

class NotificationService {
    public void sendSms() {
        System.out.println("Notification Service ::: Order confirmation SMS has been sent to the client.");
    }
}
