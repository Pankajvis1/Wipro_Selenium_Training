package OPPs;

public class poly_abstract {


	//Polymorphism- 1. compile time polymorphism -Method overloading-
//	                 1.same method name but different arguments
//	                 2. method overloading done in same class
//	              2. Runtime polymorphism- Method overriding
//	                 same method name and same arguments
//	                 2. method overriding done in different class (Is - a- relationship(inheritance))
	 
	// Abstract class


	// Abstract class
	

	// Abstract class
	abstract class Vehicle {

	    abstract void noOfTyres();

	    void type() {
	        System.out.println("Petrol / Diesel / Electric");
	    }
	}

	// Child class 1
	class Scooter extends Vehicle {

	    void noOfTyres() {
	        System.out.println("No of tyres for scooter = 2");
	    }
	}

	// Child class 2
	class Car extends Vehicle {

	    void noOfTyres() {
	        System.out.println("No of tyres for car = 4");
	    }
	}

	// Main class
	public class VehicleTest {

	    public static void main(String[] args) {

	        Vehicle sc = new Scooter();
	        sc.noOfTyres();
	        sc.type();

	        System.out.println("*********************");

	        Vehicle c = new Car();
	        c.noOfTyres();
	        c.type();
	    }
	}
}