package structural.proxy;

public class Virtual {
    public static void main(String[] args) {
        Service service = new VirtualProxy();
        service.request();
        service.request();
        service.request();
    }
}

class VirtualProxy implements Service {

    private RealService realService;

    @Override
    public void request() {
        System.out.println("Virtual Proxy ::: Start.");

        if (realService == null) {
            // Loading Lazy
            realService = new RealService();
            System.out.println("Virtual Proxy ::: Creating Real Service.");
        }

        realService.request();

        System.out.println("Virtual Proxy ::: End");
    }
    
}


