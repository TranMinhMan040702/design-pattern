package creational.singleton;

public class SingletonSyn {
    private static SingletonSyn instance;
    private SingletonSyn() {}

    public static synchronized SingletonSyn getInstance() {
        if (instance == null) {
            instance = new SingletonSyn();
        }

        return instance;
    }
}
