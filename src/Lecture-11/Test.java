import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.SecurityException;

public class Test {
    public static void main(String[] args)  throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InaccessibleObjectException, SecurityException {
        Object o = new Chess(10, 2, "SAM", "SHA");
        Class c = o.getClass();
        Method m = c.getDeclaredMethod("printBoard");
        m.setAccessible(true); // Note: uses unchecked or unsafe operations.
        m.invoke(o);
    }
}
