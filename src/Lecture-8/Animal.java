public class Animal extends LivingBeing {
    private int animalId;

    public Animal(int aid) {
        super(10, ""); // constructor of Animal immediately calling constructor of LivingBeing
        this.animalId = aid;
    }

    @Override
    public void walk() {
        System.out.println("Animal walks");
    }
}