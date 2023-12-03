import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        Game g = new Game(10, 4);
        Class c = g.getClass();
        System.out.println(c);

        Field[] fields = Game.class.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }
}
