import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// use @interface to write a new annotation
// @Target(ElementType.FIELD) // this JsonSerialized can be put on fields
// @Target(ElementType.METHOD) // this annotation can be put on methods

// RetentionPolicy: SOURCE, RUNTIME, CLASS
// SOURCE: visible to neither at compile-time nor at runtime
// RUNTIME: visible at only runtime
// CLASS:  visible at only compile-time

public class Test {
    public static void main(String[] args) {
        Person person = new Person("samar", "taj", "28", "Ujjain");
        Serialize driver = new Serialize();
        String myJsonString = driver.convertToJson(person);
        System.out.println(myJsonString);
    }
}
