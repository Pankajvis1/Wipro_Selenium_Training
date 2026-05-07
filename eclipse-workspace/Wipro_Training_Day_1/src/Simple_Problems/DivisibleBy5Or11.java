package Simple_Problems;

import java.util.Scanner;

public class DivisibleBy5Or11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		if (num % 5 == 0 || num % 11 == 0) {
			System.out.println("The number is divisible by 5 or 11.");
		} else {
			System.out.println("The number is NOT divisible by 5 or 11.");
		}

		sc.close();
	}
}