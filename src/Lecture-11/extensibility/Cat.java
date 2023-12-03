package extensibility;

public class Cat implements Animal {
    @Override
    public void move() {
        System.out.println("Cat is moving");
    }
}