package Ex_04.que3;

final class Rectangle {
    private double lx, ly, rx, ry;

    Rectangle() {
        ;
    }
    Rectangle(float lx, float ly, float rx, float ry) {
        this.lx = lx;
        this.ly = ly;
        this.rx = rx;
        this.ry = ry;
    }

    public double area() {
        return (lx - rx) * (lx - rx) + (ly - ry) * (ly - ry);
    }

    public double peri() {
        return 2 * (Math.abs(lx - rx) + Math.abs(ly - ry));
    }
}

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(1, 1, 4, 5);
        System.out.println("面积: " + a.area() + " 周长:" + a.peri());
    }
}
