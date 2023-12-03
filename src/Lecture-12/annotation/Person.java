@JsonSerialized
public class Person {
    
    @JsonElement(key = "first_name")
    private String firstName;
       
    @JsonElement(key = "last_name")
    private String lastName;

    @JsonElement(key = "age")
    private String age;
    
    private String address;

    public Person(String fn, String ln, String age, String address) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
        this.address = address;
    }

    @StringAnnotation
    private void changeString() {
        this.firstName = capitalize(this.firstName);
        this.lastName = capitalize(this.lastName);
    }

    private String capitalize(String name) {
        return  name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
