public class ChainException {
    public static void main(String[] args) {
        try {
            finalVal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main End");
    }

    public static void finalVal() throws Exception {
        try {
            Integer avg = findAvg();
            System.out.println("Avg: " + avg.toString());
        } catch (Exception e) {
            throw new Exception("while stringifying avg: " + e.getMessage(), e);
        }
        System.out.println("final Val End");
    }

    public static Integer findAvg() throws Exception {
        int age = 0;
        Integer avg = null;
        try {
            age = getAgeFromAadhar();
            System.out.println("Age: " + age);
            avg = 50/age;
        } catch (RuntimeException e) {
            throw new Exception("while finding average: " + e.getMessage(), e);
        }
        System.out.println("findAvg End");
        return avg;
    }

    public static int getAgeFromAadhar() throws InterruptedException {
        throw new InterruptedException("interruption caused due to network problem");
    }
}