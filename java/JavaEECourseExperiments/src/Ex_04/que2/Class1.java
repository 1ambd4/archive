package Ex_04.que2;

public class Class1 {
    public static void main(String[] args) {
        B b = new B();
        b.myPrint(1.2f);
    }
}

class A {
    float rear(float r) {
        return (float)Math.PI * r * r;
    }
}

class B extends A {
    float rear(float r) {
        return 4 * (float)Math.PI * r * r;
    }

    void myPrint(float r) {
        System.out.println("半径为 " + r + " 的圆的面积 = " + super.rear(r) + " 同半径的球的表面积 = " + rear(r));
    }
}
