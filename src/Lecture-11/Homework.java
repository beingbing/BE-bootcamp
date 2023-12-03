import java.lang.reflect.Method;

public class Homework {
    public static void main(String[] args) {
        Object o = new Chess(10, 2, "SAM", "SHA");
        Class c = o.getClass();
        printAllMethods(c);
    }

    private static void printAllMethods(Class c) {
        while (c != null) {
            System.out.println("Class name: " + c.getName());
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }
            c = c.getSuperclass();
            System.out.println();
        }
    }
}
