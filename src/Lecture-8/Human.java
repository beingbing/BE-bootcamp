public class Human extends LivingBeing {
    private char gender;
    private int id;

    @Override
    public void walk() {
        super.walk();
        System.out.println("Human walks");
    }
}