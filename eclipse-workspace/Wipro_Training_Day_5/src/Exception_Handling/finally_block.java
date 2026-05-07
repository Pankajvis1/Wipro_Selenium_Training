package Exception_Handling;

import java.util.Scanner;

public class finally_block {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number:");

		int a = scanner.nextInt();
		int b = 88;

		try {

			int c = b / a;

			System.out.println("Division =" + c);

		}

		catch (ArithmeticException e) {
			System.out.println(e);

		}

		finally {

			System.out.println("Passs the level");

		}
		scanner.close();
	}

}