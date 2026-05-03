package creational.singleton;

public class Singleton {
    public static void main(String[] args) {

        // Ex: Lazy
        SingletonLazy insLazy1 = SingletonLazy.getIntance();
        SingletonLazy insLazy2 = SingletonLazy.getIntance();
        System.out.println(insLazy1 == insLazy2);

        // Ex: Syn
        SingletonSyn insSyn1 = SingletonSyn.getInstance();
        SingletonSyn insSyn2 = SingletonSyn.getInstance();
        System.out.println(insSyn1 == insSyn2);

        // Ex: Eager
        SingletonSyn insEager1 = SingletonSyn.getInstance();
        SingletonSyn insEager2 = SingletonSyn.getInstance();
        System.out.println(insEager1 == insEager2);

        // Ex: DCL
        SingletonSyn insDcl1 = SingletonSyn.getInstance();
        SingletonSyn insDcl2 = SingletonSyn.getInstance();
        System.out.println(insDcl1 == insDcl2);

        // Ex: inner class
        SingletonSyn insInner1 = SingletonSyn.getInstance();
        SingletonSyn insInner2 = SingletonSyn.getInstance();
        System.out.println(insInner1 == insInner2);
    }
}
