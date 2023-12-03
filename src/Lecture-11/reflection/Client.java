package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {
    public void start(Object o, String id1, String id2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = o.getClass();
        Method method = c.getMethod("process", new Class[]{String.class, String.class});
        method.invoke(o, new Object[]{id1, id2});
    }
}