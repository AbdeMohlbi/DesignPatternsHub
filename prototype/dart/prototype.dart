class Address {
  String street;
  String city;

  Address(this.street, this.city);

  // Shallow copy
  Address clone() {
    return Address(street, city);
  }

  @override
  String toString() => 'Address(street: $street, city: $city)';
}

class Person {
  Address address;
  String name;

  Person(this.address, this.name);

  // Shallow copy
  Person clone() {
    return Person(address, name);
  }

  // Deep copy
  Person deepCopy() {
    return Person(address.clone(), name);
  }

  @override
  String toString() => 'Person(name: $name, address: $address)';
}

void main() {
  // Original object
  final original = Person(Address('123 Main St', 'New York'), 'Joe Doe');

  // Shallow copy
  final shallowCopy = original.clone();

  // Deep copy
  final deepCopy = original.deepCopy();

  print('Original: $original');
  print('Shallow Copy: $shallowCopy');
  print('Deep Copy: $deepCopy');

  // Modify the original object
  original.address.city = 'Los Angeles';
  original.name = 'Jane Doe';

  print('\nAfter modifying the original:');
  print('Original: $original');
  print('Shallow Copy: $shallowCopy');
  print('Deep Copy: $deepCopy');
}
