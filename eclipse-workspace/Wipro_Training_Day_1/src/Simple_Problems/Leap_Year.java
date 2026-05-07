package Simple_Problems;

import java.util.Scanner;

public class Leap_Year {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Year: ");

		int year = sc.nextInt();

		if (year % 4 == 0) {

			if (year % 100 == 0) {

				if (year % 400 == 0) {

					System.out.println("This is leap year: " + year);

				}

				else {

					System.out.println("This is not a leap year");
				}
			} else {
				System.out.println("This is a leap year: " + year);

			}

		} else {
			System.out.println("This is not a leap year");

		}
		sc.close();
	}

}
