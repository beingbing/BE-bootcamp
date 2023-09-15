public abstract class Game {
    // abstract class can not be instantiated

    private final String name;

    public Game(String name) {
        this.name = name;
    }

    public abstract void play();
    // if we are making a method abstroct then all the subclasses will have to implement this (this is forced)
    // in case of polymorphism, overriding was not forced

    // abstract class can have normal methods
    public void printWinner(String name) {
        System.out.println(name + " wins");
    }
}