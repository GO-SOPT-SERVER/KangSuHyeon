package abstaction;

public class Main {
    public static void main(String[] args) {
        Mouse mickey = new Mouse("미키", 85);
        Mouse.sing();
        System.out.println(mickey.getCountOfTail());
        mickey = null; //가비지 컬렉터가 더이상 참조하지 않는 힙 영역에 Mouse객체를 수거함

        Mouse jerry = new Mouse("제리", 73);
        System.out.println(jerry.getCountOfTail());
        Mouse.sing();
    }
}
