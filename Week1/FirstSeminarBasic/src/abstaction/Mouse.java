package abstaction;

public class Mouse {
    private String name;
    private int age;
    public static final int countOfTail;

    static {
        countOfTail = 1;
    }

    Mouse(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void sing() {
        System.out.println("찍찍");
    }

    public int getCountOfTail() {
        return countOfTail;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
