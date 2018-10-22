package Ex_04.que3;

final class Circle {
    private double r, a, p;

    Circle() {
        this(0);
    }
    Circle(double r) {
        this.r = r;
    }

    public void setRadius(double r) {
        this.r = r;
    }

    public double area() {
        return this.a = Math.PI * r * r;
    }

    public double peri() {
        return this.p = 2 * Math.PI * r;
    }

    public void print() {
        System.out.println("半径: " + r + " 周长: " + this.peri() + " 面积: " + this.area());
    }
}

public class TestCircle {
    public static void main(String[] args) {
        Circle a = new Circle();
        a.print();
        a.setRadius(1);
        a.print();
    }
}
