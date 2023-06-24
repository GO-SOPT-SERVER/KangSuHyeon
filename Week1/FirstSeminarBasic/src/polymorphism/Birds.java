package polymorphism;

public abstract class Birds extends Animal{
    protected final String name = "조류";
    @Override
    public void showName() {
        super.showName();
        System.out.println(super.name + "이고 " + name + "이다.");
    }

    abstract void cry(); //조류를 상속받은 클래스에서 우는 소리 구현!
}
