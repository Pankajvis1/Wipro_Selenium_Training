package Inheritance;

class Hospital {
	void Name() {
		System.out.println("Fortis Hospital ");
	}

	void Location() {
		System.out.println("Noida");

	}
}

class Doctor extends Hospital {
	void Name() {
		System.out.println("Dr. Rakesh Sharma");
	}

	void Designation()

	{
		System.out.println("CMO");
	}

}

public class Inheritance_Practice {

	public static void main(String[] args) {

		Doctor d = new Doctor();
		d.Name();
		d.Location();
		d.Designation();

	}

}
