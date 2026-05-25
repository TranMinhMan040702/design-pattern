package structural.proxy;

public class RealService implements Service{
    @Override
    public void request() {
        System.out.println("Real Service ::: Handling core business logic operations.");
    }
}
