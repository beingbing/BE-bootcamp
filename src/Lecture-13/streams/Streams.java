import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class Streams {
    public static void main(String[] args) {
        String[] myAr = new String[]{"abc", "htrey", "re"};
        
        // to convert a collection into stream
        Stream<String> myStrm = Arrays.stream(myAr);

        // to create a new stream and add something to it
        Stream<Integer> myIntStrm = Stream.<Integer>builder().add(7).add(8).build();

        // termination operation
        Predicate p = (s) -> s.equals("abc");
        boolean res = myStrm.anyMatch(p);
        System.out.println("res: " + res);

        // prob
        // write a program to count number of strings in a list that start with a specific character
        String[] strAr = new String[]{"grey", "golden", "green", "blue", "tangerine", "brown", "black", "beige"};
        int strCnt = Arrays.stream(strAr).filter((color) -> color.startsWith("b")).collect(Collectors.toList()).size();
        System.out.println("str cnt: " + strCnt);
    }
}
