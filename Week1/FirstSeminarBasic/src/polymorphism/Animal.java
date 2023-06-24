package polymorphism;

public abstract class Animal {
    protected final String name = "동물";

    public void showName() {
        System.out.println("나는" + name);
    }

    abstract void cry(); //동물마다 다른 소리를 낸다.
}
