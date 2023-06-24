package polymorphism;

public class Penguin extends Birds{
    public final String name = "펭귄";
    @Override
    public void showName() {
        super.showName();
        //super.super.showName(); //불가!
        System.out.println(super.name + "이고 " + name + "이다."); //this.name
    }

    public void showName(String name) { //오버로딩
        System.out.println(this.name + "이고 객체 이름은" + name + "이다."); //매개변수 name
    }

    @Override
    void cry() {
        System.out.println("펭귄이 어떻게 울지???");
    }
}
