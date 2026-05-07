package Assignment_Day_2;

import java.util.Scanner;

public class factorial_WhileLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int n = sc.nextInt();

		int factorial = 1;
		int i = 1;

		while (i <= n) {
			factorial *= i;
			i++;
		}

		System.out.println("Factorial of " + n 
							+ " is: " + factorial);

		sc.close();
	}
}

/*
 * Write a program to calculate the factorial of a given number using a while
 * loop.
 */