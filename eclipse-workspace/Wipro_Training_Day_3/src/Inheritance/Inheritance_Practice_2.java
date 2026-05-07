package Inheritance;
class Parent
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
class Child extends Parent
{
	void bike()
	{
		System.out.println("Pulsar");
	}
}
public class Inheritance_Practice_2 {
	
 
	public static void main(String[] args) {
		Child mohan=new Child();
		mohan.flat();
		mohan.car();
		mohan.bike();
		
		Parent soham=new Parent();
		soham.flat();
		soham.car();
		//soham.bike();
		
	}
 
}
// Single inheritance= parent-->Child
//Multilevel inheritance= GrandParent-->Parent--> Child-->SubChild.......
// Hierarchical inheritance=Parent-->Child1-->Subchild1
//                                         -->Subchild2
//                               -->Child2
//                                -->Child3
 