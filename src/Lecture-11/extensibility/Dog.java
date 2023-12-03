package extensibility;

public class Dog implements Animal {
    @Override
    public void move() {
        System.out.println("Dog is moving");
    }
}