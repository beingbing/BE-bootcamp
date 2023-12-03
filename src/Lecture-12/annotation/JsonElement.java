import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// custom annotation
@Target(ElementType.FIELD) // this JsonSerialized can be put on fields
@Retention(RetentionPolicy.RUNTIME) // as loading of classes done by JVM at runtime
public @interface JsonElement {
    public String key() default "hello";
}
