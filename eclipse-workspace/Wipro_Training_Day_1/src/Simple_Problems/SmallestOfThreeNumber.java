package Simple_Problems;

public class SmallestOfThreeNumber {

	public static void main(String[] args) {

		int a = 17;
		int b = 10;
		int c = 15;

		if (a < b && a < c) {
			System.out.println("A is the smallest number " + a);

		} else if (b < a && b < c) {
			System.out.println("B is the smallest number " + b);

		} else {
			System.out.println("C is the smallest number " + c);
		}

	}

}
