import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// custom annotation
@Target(ElementType.TYPE) // this JsonSerialized can be put on classes
@Retention(RetentionPolicy.RUNTIME) // as loading of classes done by JVM at runtime
public @interface JsonSerialized {}
