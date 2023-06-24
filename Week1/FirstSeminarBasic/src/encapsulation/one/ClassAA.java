package encapsulation.one;

//같은 패키지의 상속받은 하위 클래스
public class ClassAA extends ClassA{
    @Override
    void runSomething() {
        //pri = 1; //private 접근 불가
        def = 1;
        pro = 1;
        pub = 1;

        // 정적 멤버는 클래스명.정적멤버 형태의 접근을 권장
        //ClassA.priStatic = 1; //private 접근 불가
        ClassA.defStatic = 1;
        ClassA.proStatic = 1;
        ClassA.pubStatic = 1;
    }

    //static 메서드에는 @Override X
    static void runStaticThing() {
        // 객체를 생성하지 않고는 객체 멤버 접근 불가
        // pri = 1;

        // 부모 객체에 직접 접근하는 것은 캡슐화 위반
        //ClassA.priStatic = 1; //private 접근 불가
        ClassA.defStatic = 1;
        ClassA.proStatic = 1;
        ClassA.pubStatic = 1;

        // 객체 멤버를 객체 생성 후에 객체 참조 변수를 통해 접근 가능
        ClassAA classAA = new ClassAA();
        //classAA.pri = 1;
        classAA.def = 1;
        classAA.pro = 1;
        classAA.pub = 1;

        //부모 객체에 직접 접근하는 것은 캡슐화 위반
        ClassA classA = new ClassA();
        //classA.pri = 1;
        classA.def = 1;
        classA.pro = 1;
        classA.pub = 1;
    }
}
