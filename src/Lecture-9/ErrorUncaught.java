public class ErrorUncaught {
    public static void main(String[] args) {
        int x = 23;
        int y = 0;
        ErrorUncaught.callme();
    }

//    public static void callme() {
//        int x = 0;
//        int z = 50 / x;
//        System.out.println("Divison: " + z);
//    }

    /**
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     *         at ErrorUncaught.callme(ErrorUncaught.java:10)
     *         at ErrorUncaught.main(ErrorUncaught.java:5)
     *
     *         got this error while running above code.
     *         This is the Exception handling done by JVM.
     *
     *         And the way of handling of JVM is, before terminating the code
     *         it is printing something for the developer.
     *
     *         whenever an Exception occurs, an error is produced
     *
     *         default Exception handler behavior:
     *         1. find the problem
     *         2. print a message for developer to inform about the error that occured
     *         3. (receive the error information from developer)
     *         4. terminate the code (or, take the corrective action)
     *         *the message written in () is not happening by default but can be done*
     *
     *         what if you do not want to terminate the thread due to an error.
     *
     *         in 2. JVM creates an Object for developer to inform about the error occured,
     *         this Object is called Exception. That means there is a class by the name of
     *         Exception and whenever an error occurs, JVM creates an object of that class
     *         to inform about us of what is going wrong. Java has different types of Exceptions
     *         objects for different types of errors. (We can also create a custom error
     *         object of an Exception type).
     *
     *         in above Exception logged by JVM, we can see the error message, which is `java.lang.ArithmeticException: / by zero`.
     *         This was composed by JVM when it was creating the object of Exception. Also, JVM
     *         provides us with the stack-trace of the origin of the error and how JVM reached
     *         that line from the starting statement of the code.
     *
     *         we can perform what is written in () in  step 3 and 4 using try-catch block.
     */

    public static void callme() {
        int z;
        try {
            int x = 0;
            z = 50 / x;
            System.out.println("Divison: " + z);
        } catch (Exception e) { // we are not creating a new object here, we are just catching the object created by JVM when it encountered the error
            // System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            z = 0;
        }
        System.out.println("End: " + z);
    }

}
