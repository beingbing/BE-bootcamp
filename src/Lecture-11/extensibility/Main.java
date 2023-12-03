package extensibility;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from main in extensibility");

        List<Animal> animalsList = new ArrayList<Animal>();
        animalsList.add(new Cat());
        animalsList.add(new Dog());
        animalsList.add(new Cat());

        play(animalsList);
    }

// As both Cat and Dog had a common parent so we didn't need to know
// which type of Object it is until it's class implements Animal interface
    public static void play(List<Animal> list) {
        for (Animal animal : list) {
            animal.move();
        }
    }
}
