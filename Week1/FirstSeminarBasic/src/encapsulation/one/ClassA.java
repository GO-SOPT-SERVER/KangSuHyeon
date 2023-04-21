package encapsulation.one;

public class ClassA { //상위 클래스 - 접근제어자
    private int pri;
    int def;
    protected int pro;
    public int pub;
    static private int priStatic;
    static int defStatic;
    static protected int proStatic;
    static public int pubStatic;

    void runSomething() {
        System.out.println("runSomething");
    }

    static void runStaticThing() {
        System.out.println("runStaticSomething");
    }
}
