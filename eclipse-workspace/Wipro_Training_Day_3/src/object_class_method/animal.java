package object_class_method;

public class animal {
	
	void sound(String animalname, String sound) 
	{
		System.out.println("Animal name " +animalname);
		System.out.println("Animal sound " +sound);
	}
	void show()
	{
		System.out.println("Nothing to say");
		
	}
	public static void main(String[] args) {
		animal dog = new animal();
		dog.sound("Max", "Barking");
		System.out.println("******************");
		animal cat = new animal();
		cat.sound("Kitty", "Meowww");

	}

}
