void main() {
  var Person = Singelton();
  var anotherPerson = Singelton();

  print(Person);
  print(anotherPerson);

  var Check =
      identical(Person, anotherPerson)
          ? "We are both the same ${Singelton.name}."
          : "We are NOT the same. I mean, just look at us.";
  print(Check);

  /*
    Hello, my name is Singelton.
    Hello, my name is Singelton.
    We are both the same Singelton.
  */
}

class Singelton {
  static final Singelton instance = Singelton._internal();
  static String _name = "Singelton";

  static String get name => _name;
  static void set name(String newName) {
    _name = newName;
  }

  factory Singelton() {
    return instance;
  }

  Singelton._internal(); // private constructor

  @override
  String toString() => "Hello, my name is $name."; // override the toString
}
