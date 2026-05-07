package Keywords;

public class super_keyword {

	static class Animal { // Parent class

		Animal(String food, String sound) {
			System.out.println("Eat = " + food);
			System.out.println("Sound = " + sound);
		}
	}

	static class Dog extends Animal { // Child class

		Dog() {
			super("Royal Canin", "Barking"); // using super keyword in constructor
			System.out.println("Color = Black");
		}
	}

	static class Cat extends Animal {

		Cat() {
			super("Fish", "Meow"); // using super keyword in constructor
			System.out.println("Cat Walk");
		}
	}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Dog d = new Dog();

		System.out.println();

		@SuppressWarnings("unused")
		Cat c = new Cat();
	}
}