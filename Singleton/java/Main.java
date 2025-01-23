
class Singleton1 { // lazy initialization
    static String name;
    static Singleton1 instance;

    private Singleton1() {
        name = "default name";
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Singleton1.name = name;
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

class Singleton2 { // eager initialization
    static String name;
    static Singleton2 instance = new Singleton2();

    private Singleton2() {
        name = "default name";
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Singleton1.name = name;
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

enum Singleton3 { // usage of an enum
    INSTANCE;

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        s1.setName("it is a singleton with lazy initialization");
        System.out.println(s1 == s2); // true
        System.out.println(s1.getName() == s2.getName()); // true

        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        s3.setName("it is a singleton with eager initialization");
        System.out.println(s3 == s4); // true
        System.out.println(s3.getName() == s4.getName()); // true

        Singleton3 s5 = Singleton3.INSTANCE;
        Singleton3 s6 = Singleton3.INSTANCE;
        s1.setName("it is a singleton using enum");
        System.out.println(s5 == s6); // true
        System.out.println(s5.getName() == s6.getName()); // true
    }
}