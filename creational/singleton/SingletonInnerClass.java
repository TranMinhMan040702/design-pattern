package creational.singleton;

public class SingletonInnerClass {
    private SingletonInnerClass() {}

    private static class SingletonMain {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonMain.INSTANCE;
    }
}
