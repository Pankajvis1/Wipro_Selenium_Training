package Keywords;

class Animal {

    int x = 100;

    String name, type;

    void eat(int x, String name, String type) {

        this.x = x;       // refer current class variable
        this.name = name;
        this.type = type;

        System.out.println("X = " + this.x);
        System.out.println("Name = " + this.name);
        System.out.println("Type = " + this.type);
    }

    void details() {

        this.eat(100, "Max", "Dog");   // refer current class method

        // calling different class method
        System.out.println("Calling different class method");
    }

    Animal() {

        System.out.println("Default constructor");
    }

    Animal(int a) {

        this();   // calling current class constructor
    }
}

public class this2_keyword {

    public static void main(String[] args) {

        Animal a = new Animal(1);
        a.details();
    }
}