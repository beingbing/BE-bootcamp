package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // super extensible system uses reflection as inheritance has limitation
        new Client().start(new ExternalLibrary());
        new Client().start(new CustomLibrary());
    }
}