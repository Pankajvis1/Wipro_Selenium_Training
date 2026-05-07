package Simple_Problems;

import java.util.Scanner;

public class Check_Positive_Negative_Zero {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any possitve or negative number: ");
		int num = sc.nextInt();

		if (num > 0) {
			System.out.println("This is a possitive num");
		} else if (num < 0) {

			System.out.println("This is a negative num");
		} else {
			System.out.println("The number is zero");

		}
		sc.close();

	}

}
