package creational.factory;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        String type = args[0];

        switch (type) {
            case "1":
                new TruckFactory().start();
                break;
            case "2":
                new ShipFactory().start();
                break;
            default:
                break;
        }
    }
}

abstract class TransportFactory {
    abstract public Transport createTransport();
    public void start() {
        Transport transport = createTransport();
        transport.book();
        transport.prepare();
        transport.delivery();
    }
}

class TruckFactory extends TransportFactory {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class ShipFactory extends TransportFactory {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

interface Transport {
    void book();
    void prepare();
    void delivery();
}

class Truck implements Transport {

    @Override
    public void book() {
        System.out.println("Booking truck");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing gas");
    }

    @Override
    public void delivery() {
        System.out.println("Delivery in road");
    }
}

class Ship implements Transport {
        
    @Override
    public void book() {
        System.out.println("Booking ship");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing oil");
    }

    @Override
    public void delivery() {
        System.out.println("Delivery in sea");
    }
}
