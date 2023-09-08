public class Pattern {
    public static void main(String args[]) {
        /* 1.
        * ****
        * ****
        * ****
        * ****
        * ****
        * */
        printPattern1();
    }

    private static void printPattern1() {
        for (int row = 1; row <=5; row++) {
            for (int col = 1; col <= 4; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}