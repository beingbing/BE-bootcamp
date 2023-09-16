public class NestedCase {
    public static void main(String[] args) {
        try {
            int x = 23;
            int y = 0;
            NestedCase.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }

    static int method1() {
        // doing some task
        method2();
        return 0;
    }

    static int method2() {
        // some other task
        int z = 0;
        int y = 50 / z;
        return 0;
    }

    /**
     *      JVM will look for exception handler in complete stack, not only in the method.
     *      Wherever it founds the first handler, going in reverse from the line of error
     *      to the top of the stack JVM will use it and pass the control to that handler
     *      along with providing the Exception object which it created.
     *      This is the Exception handling done by JVM and this is how we avoid the Nested
     *      handling of probable exception by each method involved in stack.
     *
     *      This is called Exception Propagation.
     *
     *
     */
}
