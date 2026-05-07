package Simple_Problems;

public class LargestOfThree_Num {

	public static void main(String[] args) {

		int a = 4;
		int b = 5;
		int c = 9;

		if (a > b && a > c) {
			System.out.println("Largest number is a: " + a);

		} else if (b > a && b > c) {

			System.out.println("Largest number is b: " + b);
		}

		else {

			System.out.println("Largest number is c: " + c);
		}

	}

}
