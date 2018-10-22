package Ex_03.que3;

public class Prime {
    public static boolean isPrime(int n) {
        int st = (int)Math.sqrt(n);
        for (int i = 2; i <= st; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 100; i <= 2000; i++) {
            if (isPrime(i)) {
                cnt++;
                System.out.print(i + " ");
                if ((cnt % 5) == 0) {
                    cnt = 0;
                    System.out.println();
                }
            }
        }
    }
}
