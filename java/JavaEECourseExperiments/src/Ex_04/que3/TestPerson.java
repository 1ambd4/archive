package Ex_04.que3;

import java.util.Scanner;

final class Person {
    private String id;
    private String name;
    private String sex;
    private String day;
    private String address;

    Person() {
        this("000000", "NULL", " ", "0000-00-00", "NULL");
    }
    Person(String id, String name, String sex, String day, String adress) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.day = day;
        this.address = address;
    }

    public void setInfo(String id, String name, String sex, String day, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.day = day;
        this.address = address;
    }

    public void showInfo() {
        System.out.println(id + " " + name + " " + sex + " " + day + " " + address);
    }
}

public class TestPerson {
    public static void main(String[] args) {
        Person a = new Person();
        Scanner cin = new Scanner(System.in);
        String id = cin.nextLine();
        String na = cin.nextLine();
        String se = cin.nextLine();
        String da = cin.nextLine();
        String ad = cin.nextLine();
        a.setInfo(id, na, se, da, ad);
        a.showInfo();
    }
}
