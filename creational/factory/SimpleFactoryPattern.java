package creational.factory;

public class SimpleFactoryPattern {
    public static void main(String[] args) {
        String vol = args[0];
        Truck truck = TruckFactory.createTruck(vol);

        if (truck != null) {
            System.out.println(truck.toString());
        }
        
    }
}

class TruckFactory {
    private TruckFactory() {
        super();
    }

    public static Truck createTruck(String cargoVolume) {
        return switch (cargoVolume) {
            case "1" -> new Truck("Truck 10", 2, 10);
            case "2" -> new Truck("Truck 20", 6, 20);
            default -> null;
        };
    }
}

class Truck {
    private String name;
    private int doors;
    private double price;

    public Truck(String name, int doors, double price) {
        this.name = name;
        this.doors = doors;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDoors() {
        return doors;
    }
    
    public void setDoors(int doors) {
        this.doors = doors;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " " + this.doors + " " + this.price;
    }
}