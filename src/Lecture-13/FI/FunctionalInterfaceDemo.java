import java.util.Optional;
import java.util.function.Consumer;

public class FunctionalInterfaceDemo {
    
    public static void main(String[] args) {
        OurFunction<Integer, String> func = (str) -> str.length();

        Optional<String> valOpt = Optional.of("Sam");
        Consumer<String> c = (str) -> System.out.println(str.length());
        valOpt.ifPresent(c);
    }

}
