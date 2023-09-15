public class Tester {

    public static void doSth(LivingBeing l) {
        l.walk();
    }

    public static void main(String[] args) {
        // Animal a = new Human(); // not allowed, incompatible types error

        LivingBeing l = new Animal();
        l.walk();
        l = new Human();
        l.walk();
        // both object assignments are allowed. This is called Polymorphism

        // both walk() calls will print different things, because they are called on different objects
        // although pointer to that object was same
        // using this idea we can write generic piece of code

        doSth(new Animal());
        doSth(new Human());
        doSth(new Bird());
        // as Bird() do not have any implementation of walk() hence, it's implementation will be looked inside Parent class

        Bird b = new Bird();
        b.fly();

        LivingBeing l2 = new Bird();
        // l2.fly(); // not allowed as LivingBeing pointer do not have access to properties specific to Bird class
        // in this case, we need to use Bird class object via casting
        ((Bird) l2).fly();

        // but below mistake can also be made by following above concept
        LivingBeing l3 = new Animal();
        // ((Bird) l3).fly(); // runtime error will be thrown, class Animal can not be cast to class Bird
        // so doing casting from super type to sub type can be dangerous withough verifying the type of object instance
        // because we do not know what kind object l3 polymorphic type was pointing to
        // we can use instanceof keyword to verify the type of object instance, but this is not recommended as it
        // if (l3 instanceof Bird) {}
        // is a costly operation and it is against the idea of polymorphism
        // so what is suggested is, if you are using polymorphic pointer to point to object of sub type
        // then work only on properties reachable to that polymorphic pointer

        // Levels of abstraction:
        // when we point to a sub type via a pointer to super type, we just want to work with those generic properties
        // which are present (and common) in all sub types, irrespective of what types of objects they are
        // example - a Player class has play() method which is common to all types of players
        // now, we have two sub types HumanPlayer and ComputerPlayer
        // both will know about play(), and to start a game we just need to invoke that
        // irrespective of what kind of players are playing



        Game g = new Chess();
        g.play();
    }

}