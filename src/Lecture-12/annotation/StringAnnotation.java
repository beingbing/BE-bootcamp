import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// custom annotation
@Target(ElementType.METHOD) // this JsonSerialized can be put on methods
@Retention(RetentionPolicy.RUNTIME) // as loading of classes done by JVM at runtime
public @interface StringAnnotation {}
