import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str += " is in virtual world now. Give radius to calculate circumference";
        System.out.println(str);
        Double radius = sc.nextDouble();
        Double circumference = calcCircumference(radius);
        System.out.println(circumference);
        System.out.println("give number to find factorial");
        int num = sc.nextInt();
        System.out.println("factorial is " + factorial(num));
    }

    private static Double calcCircumference(Double radius) {
        return 2 * Math.PI * radius;
    }

    private static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}