public class LivingBeing {
    private int age;
    private String dnaSeq;

    public LivingBeing(int a, String d) {
        this.age = a;
        this.dnaSeq = d;
    }

    public void walk() {
        System.out.println("Default walk");
    }
}