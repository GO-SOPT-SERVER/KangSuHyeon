package encapsulation.two;

import encapsulation.one.ClassA;

//다른 패키지의 다른 클래스
public class ClassC {
    void runSomething() {
        //다른 클래스이므로 당연히 접근 불가
        //pri = 1;

        // 정적 멤버
        //ClassA.priStatic = 1; //private 접근 불가
        //ClassA.defStatic = 1; //다른 패키지 접근 불가
        //ClassA.proStatic = 1; //다른 패키지 접근 불가
        ClassA.pubStatic = 1;
    }

    static void runStaticThing() {
        // 정적 멤버
        //ClassA.priStatic = 1; //private 접근 불가
        //ClassA.defStatic = 1; //다른 패키지 접근 불가
        //ClassA.proStatic = 1; //다른 패키지 접근 불가
        ClassA.pubStatic = 1;

        //객체 멤버 상속 받지 않았으므로 당연히 접근 불가
        ClassC classC = new ClassC();
        //classC.pri = 1;

        ClassA classA = new ClassA();
        //classA.pri = 1;
        //classA.def = 1;
        //classA.pro = 1;
        classA.pub = 1;
    }
}