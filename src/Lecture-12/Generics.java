import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Generics {
    public static void main(String[] args) {
        // Map<String, Integer> nameMap = new HashMap<>();
        // Integer value = nameMap.computeIfAbsent("John", s -> s.length());

        // prob 2
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = fromArrayToList(intArray, Object::toString);
        System.out.println("String-list: " + stringList);
    }

    // prob 1
    // collection -> string
    // collection -> int
    // traverse and print the value irrespective of data-type using generic
    public <T> void printString(T[] myList) {
        //
    }

    // method definition using more than 1 data type
    public static <T, G> List<G> fromArrayToList(T[] someArray) {
        return new ArrayList<>();
    }

    // prob 2
    // convert a list of numbers into string
    // Note: signature can also be written like:
    // to bound generic to only take a particular type of data-types
    // public static <T extends Number, G > List<G>
    public static <T, G > List<G> fromArrayToList(T[] someArray, Function<T,G> mapper) {
       System.out.println(someArray.length);
       return Arrays.stream(someArray).map(mapper).collect(Collectors.toList());
    }

}
