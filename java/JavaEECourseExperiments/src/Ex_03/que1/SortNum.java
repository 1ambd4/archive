package Ex_03.que1;

public class SortNum {
    public static void main(String[] args) {
        int a = 9;
        int b = 5;
        int c = 7;
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        System.out.println("a = " + a + " b = " + b + " c = " + c);
    }
}