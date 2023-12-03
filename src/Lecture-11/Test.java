import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Object o = new Game(10, 4);
        Class c = o.getClass();
        System.out.println(c);
        System.out.println(c.getName());

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
