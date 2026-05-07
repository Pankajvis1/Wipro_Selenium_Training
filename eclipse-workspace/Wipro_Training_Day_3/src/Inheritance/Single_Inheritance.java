package Inheritance;
class Animal// parent  class/ base class . / Super class
{
	void eat(String eat) {
		System.out.println("Eat ="+eat);
	}
	void sound(String sd)
	{
		System.out.println("Sound ="+sd);
	}
}
class Dog extends Animal// child class/ sub class/ extended class
{
	void color()
	{
		System.out.println("Black");
	}
}
class Cat extends Animal
{
	void walk()
	{
		System.out.println("Cat Walk");
	}
}
 
public class Single_Inheritance {
 
	public static void main(String[] args) {
		Dog d=new Dog();
		d.color();
		d.eat("Royal canin");
		d.sound("Barking");
		//
		Cat c=new Cat();
		c.walk();
		c.eat("Fish");
		c.sound("Meow");
		//
		
		
	}
 
}