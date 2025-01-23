class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Person implements Cloneable {
    private Address address;
    private String name;

    public Person(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Shallow copy
    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // This should never happen
        }
    }

    // Deep copy
    public Person deepCopy() {
        Address newAddress = new Address(address.getStreet(), address.getCity());
        return new Person(newAddress, new String(name));
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Original object
        Address address = new Address("123 Main St", "New York");
        Person person = new Person(address, "Joe Doe");

        // Shallow copy
        Person shallowCopy = person.clone();

        // Deep copy
        Person deepCopy = person.deepCopy();

        System.out.println("Original: " + person);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);

        // Modify the original
        person.getAddress().setCity("Los Angeles");
        person.setName("Jane Doe");

        System.out.println("\nAfter modifying the original:");
        System.out.println("Original: " + person);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("Deep Copy: " + deepCopy);
    }
}
