package Ex_03.que3;

public class Fac {
    public static int fac(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        else {
            return fac(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        int ans = fac(10);
        System.out.println(ans);
    }
}
