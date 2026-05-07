package Inheritance;
class Grandparent1
{
	void openland()
	{
		System.out.println("Openland for commercial use");
	}
}
class Parent1 extends Grandparent1
{
	void flat()
	{
		System.out.println("2BHK");
	}
	void car()
	{
		System.out.println("BAleno Petrol car");
	}
}
class Parent2 extends Grandparent1
{
	void flat()
	{
		System.out.println("2BHK");
	}
	void car()
	{
		System.out.println("BAleno Petrol car");
	}
}
class Childp1 extends Parent1
{
	void bike()
	{
		System.out.println("Pulsar");
	}
}
class Child1p2 extends Parent2
{
	void bike()
	{
		System.out.println("Pulsar");
	}
}
 
public class Hierarchical_Inheritance {
	
 
	public static void main(String[] args) {
		Childp1 mohan=new Childp1();
		mohan.flat();// self
		mohan.car();// parent
		mohan.bike();// parent
		mohan.openland();// grandparent
		
		Child1p2 raj=new Child1p2();
		raj.flat();// self
		raj.car();// parent
		raj.bike();// parent
		raj.openland();// grandparent
		
		Parent1 soham = new Parent1();
		soham.flat();// self
		soham.car();// parent
		soham.openland();// grandparent
		
		Parent2 vinesh = new Parent2();
		vinesh.flat();// self
		vinesh.car();// parent
		vinesh.openland();// grandparent
		 
		Grandparent1 rakesh = new Grandparent1();
		rakesh.openland();
		
				
		
		
		
	}
 
}