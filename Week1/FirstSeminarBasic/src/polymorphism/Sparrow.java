package polymorphism;

public class Sparrow extends Birds implements AbleToFly{
    public final String name = "참새";
    @Override
    public void showName() {
        super.showName();
        System.out.println(super.name + "이고 " + name + "이다."); //this.name
    }

    @Override
    public void fly() {
        System.out.println("날 수 있다!");
    }

    @Override
    void cry() {
        System.out.println("짹짹");
    }
}
