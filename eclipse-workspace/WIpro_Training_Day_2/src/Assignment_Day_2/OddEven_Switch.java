package Assignment_Day_2;

import java.util.Scanner;

public class OddEven_Switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter any number: ");
		int num = sc.nextInt();

		switch (num % 2) {

		case 0:
			System.out.println("Result = Even Number");
			break;

		case 1:
			System.out.println("Result = Odd Number");
			break;

		default:
			System.out.println("Invalid Output");
			break;
		}

		sc.close();
	}
}