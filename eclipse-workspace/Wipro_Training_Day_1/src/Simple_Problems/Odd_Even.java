package Simple_Problems;

import java.util.Scanner;

public class Odd_Even {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number: ");

		int num = sc.nextInt();

		if (num % 2 == 0) {

			System.out.println("This is an Even number");
		}

		else {

			System.out.println("This is a Odd Number");
		}

		sc.close();
	}

}
