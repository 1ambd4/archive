package Ex_03.que2;

public class U2 {
    public static void main(String[] args) {
        int score = 55;
        switch(score / 10) {
            case 0: case 1: case 2: case 3: case 4: case 5: {
                System.out.println(score + "分是 D 等级");
                break;
            }
            case 6: {
                System.out.println(score + "分是 C 等级");
                break;
            }
            case 7: case 8: {
                System.out.println(score + "分是 B 等级");
                break;
            }
            case 9: case 10: {
                System.out.println(score + "分是 A 等级");
                break;
            }
            default: {
                System.out.println("数据错误");
            }
        }
    }
}
