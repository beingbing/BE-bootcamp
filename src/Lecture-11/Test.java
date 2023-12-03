import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Object o = new Chess(10, 2, "SAM", "SHA");
        Class c = o.getClass();
        // System.out.println(c);
        // System.out.println(c.getName());

        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
