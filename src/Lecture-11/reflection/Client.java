package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {
    public void start(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = o.getClass();
        Method method = c.getMethod("process");
        method.invoke(o);
    }
}