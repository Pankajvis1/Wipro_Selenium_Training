package Assignment_Day_2;

import java.util.Scanner;

public class primeNumber_WhileLoop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int num = sc.nextInt();

		int i = 2;
		boolean isPrime = true;

		while (i <= num / 2) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
			i++;
		}

		if (num <= 1) {
			System.out.println("Not a Prime Number");
		} else if (isPrime) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not a Prime Number");
		}

		sc.close();
	}
}