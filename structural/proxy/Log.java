package structural.proxy;

public class Log {
    public static void main(String[] args) {
        Service service = new ProxyService(new RealService());
        service.request();
    }
}

class ProxyService  implements Service {
    private RealService realService;

    public ProxyService(RealService realService) {
        this.realService = realService;
    }

    private void authenticate() {
        System.out.println("Logging ::: Authenticating user permissions.");
    }

    private void cleanUp() {
        System.out.println("Logging ::: Performing database connection cleanup.");
    }

    @Override
    public void request() {
        authenticate();

        realService.request();

        cleanUp();
    }
    
}
