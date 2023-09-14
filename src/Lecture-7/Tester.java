import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        File f = new File("test.txt", 100, new FileMetaData(new Date(), new Date(), 1)); // an object is created inside heap memory
        // 'f' is just a pointer to the object of type File

        // final: immutable (can not be changed)
//        final int x = 5;
//        x = 10;
        // we can not do abouve steps because x is final
        // but with final primitve types and non-primitive types behave differently
        // for primitive type, final keywords restrict assignment of new values
        // with non-primitive types, final keyword only restrict pointing of that variable to a new object
        // but we can still assign new values to the fields of object pointed by that variable

        // so if i want to have a non-primitive type to be truly immutable, then i need to make
        // it recursively immutable
        // that means, all the fields of the object (that is pointed by our final variable) should be final
        // ex:
        // class Person {
        //     final String name;
        //     final int age;
        // }
        // final Person p = new Person();
        // p.name = "John"; // not allowed
        // now object p is recursively immutable

        // also, all final variables must be initialized

        // in above example, 'f' is not recursively final, because although File class has all the fields
        // set to be final but it also has a FileMetaData class object which has fields that can be
        // modified, as they are not final

        File f2 = new File("newFile.txt", 80, new FileMetaData(new Date(), new Date(), 2));
        System.out.println(File.getCount());
        System.out.println(f.cmp(f2));
    }
}