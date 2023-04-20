package polymorphism;

public class Main {
    public static void main(String[] args) {
        Penguin pororo = new Penguin();

        pororo.showName(); //동물 -> 조류 -> 펭귄
        pororo.showName("뽀로로");
        //pororo.fly(); //error
        pororo.cry(); //"펭귄이 어떻게 울지???"

        Animal pingu = new Penguin();
        pingu.showName(); //동물 -> 조류 -> 펭귄
        //pingu.showName("핑구"); //Animal형이기 때문에 바로 접근 불가

        Sparrow sparrow = new Sparrow();
        sparrow.fly();
        sparrow.cry(); //짹짹

    }
}
