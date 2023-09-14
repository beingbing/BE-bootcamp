public class File {
    // we make class fields private so that they can't be changed from outside directly
    // that's called data hiding / maintaining data integrity
    // data integrity means accepting only those values for a class field which are sane
    // and logical from our perspective
    private String name;
    private int sizeInBytes;

    private static int count = 0;
    // static makes a variable specific to a class, hence it will be shared by all the
    // objects of the class
    // static variables are initialized when classes are loaded
    // class loading happens happens after compilation
    // class loading happens when JVM comes into picture


    final FileMetaData fileMetaData;

    public File(String name, int sizeInBytes, FileMetaData fileMetaData) { // creates a variable with class fields having solid values
        this.name = name;
        if (sizeInBytes <= 0) throw new RuntimeException("Illegal size");
        this.sizeInBytes = sizeInBytes;
        this.fileMetaData = fileMetaData;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new RuntimeException("Illegal name");
        this.name = name;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(int sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    // this idea of making data members as private (data hiding) and
    // exposing them via public getters and setters is called encapsulation

    public static int getCount() {
//        int x = sizeInBytes;
        // "Non-static field/method can not be referenced from a static context"
        // this error is thrown because the static method can be called using class name,
        // but there is no guarantee that the non-static field will be available/initialized
        // also, if a static method if referencing a non-static variable, we can not
        // figure out for which instance/object, it is referred
        // but the reverse can be done
        // static field/method can be referenced from non-static context
        return count;
    }

    // if a method is made static, then i can call it without creating an object
    // to access static variables, it is better to keep getters as static as well
    // so that the methods are not dependent on the object and we can call them using class name


    // this keyword:
    // it refers to the current object

    public boolean cmp(File f) {
        return this.name.equals(f.name) && this.sizeInBytes == f.sizeInBytes;
    }

}
