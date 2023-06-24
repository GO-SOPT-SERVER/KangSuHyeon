package encapsulation.two;

import encapsulation.one.ClassA;

//다른 패키지의 상속받은 하위 클래스
public class ClassAB extends ClassA{
   //@Override //왜 안되는지..?
    void runSomething() {
        //pri = 1; //private 접근 불가
        //def = 1; //다른 패키지이므로 접근 불가
        pro = 1;
        pub = 1;

        // 정적 멤버
        //ClassA.priStatic = 1; //private 접근 불가
        //ClassA.defStatic = 1; //다른 패키지이므로 접근 불가
        ClassA.proStatic = 1;
        ClassA.pubStatic = 1;
    }

    //static 메서드에는 @Override X
    static void runStaticThing() {
        // 객체를 생성하지 않고는 객체 멤버 접근 불가
        // pri = 1;

        //부모 객체에 직접 접근하는 것은 캡슐화 위반/ 정적 멤버
        //ClassA.priStatic = 1; //private 접근 불가
        //ClassA.defStatic = 1; //다른 패키지이므로 접근 불가
        ClassA.proStatic = 1; //자식이기 때문에 접근 가능
        ClassA.pubStatic = 1;

        // 객체 멤버를 객체 생성 후에 객체 참조 변수를 통해 접근 가능
        ClassAB classAB = new ClassAB();
        //classAB.pri = 1;
        //classAB.def = 1; //다른 패키지이므로 접근 불가
        classAB.pro = 1; //자식 객체에서는 부모의 pro에 접근 가능
        classAB.pub = 1;

        //부모 객체에 직접 접근하는 것은 캡슐화 위반
        ClassA classA = new ClassA();
        //classA.pri = 1;
        //classA.def = 1;
        //classA.pro = 1; //직접 접근 NO!
        classA.pub = 1;
    }
}