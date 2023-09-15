public class WildAnimal extends Animal {
    private double wildness;

    public WildAnimal(double wildness) {
        super(9); // constructor of WildAnimal immediately calling constructor of Animal
        this.wildness = wildness;
    }
}