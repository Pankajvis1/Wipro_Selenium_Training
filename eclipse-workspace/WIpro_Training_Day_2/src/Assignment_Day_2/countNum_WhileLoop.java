package Assignment_Day_2;

import java.util.Scanner;

public class countNum_WhileLoop {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number: ");
		int num = sc.nextInt();

		int count = 0;

		while (num != 0) {
			num = num / 10;
			count++;

		}

		System.out.println("Number of digits = " + count);

		sc.close();
	}

}

/*
 * Write a program to count the number of digits in a given number using a while
 * loop.
 */