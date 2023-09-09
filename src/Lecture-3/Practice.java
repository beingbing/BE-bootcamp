import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        /*
        * 1. make pattern like below: take input of rows (if 5) -
        *   ____xxxxx
        *   ___xxxxx
        *   __xxxxx
        *   _xxxxx
        *   xxxxx
        * */
        System.out.println("Enter number of rows: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        printPattern(rows);

        /*
         * 2. write function to find GCD/HCF of two numbers
         * */

        /*
         * 3. print values of a 2D array in spiral order
         * */

        /*
         * 4. find the transpose of a matrix
         * */
    }

    private static void printPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows-i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= rows; k++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}