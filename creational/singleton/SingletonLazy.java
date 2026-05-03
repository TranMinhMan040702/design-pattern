package creational.singleton;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getIntance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}
