package Inheritance;

class Grandparent {
	void openland() {
		System.out.println("Openland for commercial use");
	}
}

class Parent_r extends Grandparent {
	void flat() {
		System.out.println("2BHK");
	}

	void car() {
		System.out.println("BAleno Petrol car");
	}
}

class Child_r extends Parent_r {
	void bike() {
		System.out.println("Pulsar");
	}
}

public class Multilevel_Inheritance {

	public static void main(final String[] args) {
		final Child_r mohan = new Child_r();
		mohan.flat();
		mohan.car();
		mohan.bike();
		mohan.openland();

		final Parent_r soham = new Parent_r();
		soham.flat();
		soham.car();
		soham.openland();

		final Grandparent rakesh = new Grandparent();
		rakesh.openland();

	}

}
