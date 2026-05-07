package Assignment_Day_2;

import java.util.Scanner;

public class FibonacciSeries_WhileLoop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of terms: ");
		int n = sc.nextInt();

		int first = 0;
		int second = 1;
		int i = 1;

		while (i <= n) {
			System.out.print(first + " ");

			int next = first + second;
			first = second;
			second = next;

			i++;
		}

		sc.close();
	}
}