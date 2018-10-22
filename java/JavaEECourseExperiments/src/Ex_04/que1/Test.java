package Ex_04.que1;

class Person {
    String name;
    char sex;
    int age;
    public Person(String s, char c, int i) {
        name = s;
        sex = c;
        age = i;
    }
    public String toString() {
        String s = "姓名: " + name + " 性别： " + sex + " 年龄： " + age;
        return s;
    }
}
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("张三", '男', 20);
        Person p2 = new Person("李四", '女', 28);
        p1.sex = '女';
        System.out.println(p1.toString());
        p2.age = 33;
        System.out.println(p2.toString());
    }
}
