package Assignment_Day_2;

import java.util.Scanner;

public class Grades_Switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any grade from ('A', 'B', 'C', 'D', 'F') :");

		char ch = Character.toUpperCase(sc.next().charAt(0));

		switch (ch) {

		case ('A'):

			System.out.println("Passed with Outstanding title");
		break;

		case ('B'):

			System.out.println("Passed with Excelent title");
		break;

		case ('C'):

			System.out.println("Passed with Average title");
		break;

		case ('D'):

			System.out.println("Passed with Good title (Need to improve) ");
		break;

		case ('F'):

			System.out.println("Fail");
		break;

		default:
			System.out.println("Invalid input");
		}

		sc.close();
	}

}
