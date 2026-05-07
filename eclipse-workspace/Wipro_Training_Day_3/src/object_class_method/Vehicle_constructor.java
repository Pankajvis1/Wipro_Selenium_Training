package object_class_method;

public class Vehicle_constructor {
	
	Vehicle_constructor()
	
	{
		System.out.println("Default Constructor");
	}
	
	Vehicle_constructor(String name)
	{
		System.out.println(name);
		
	}
	
	Vehicle_constructor(String name, String type)
	{
		System.out.println(name);
		System.out.println(type);
	}
	public static void main(String[] args) {
		Vehicle_constructor vc = new Vehicle_constructor("Beleno car");
		System.out.println("*************");
		Vehicle_constructor vc1 = new Vehicle_constructor("Baleno car", "Petrol car");
		
		

	}

}
