package Assignment_Day_2;

import java.util.Scanner;

public class VowelCheck_switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any character: ");

		char ch = sc.next().charAt(0);

		switch (ch) {

		case ('a'):
			System.out.println("This is a vowel ");
		break;

		case ('i'):
			System.out.println("This is a vowel ");
		break;

		case ('e'):
			System.out.println("This is a vowel ");
		break;

		case ('o'):
			System.out.println("This is a vowel ");
		break;

		case ('u'):
			System.out.println("This is a vowel ");
		break;

		default:
			System.out.println("This is a consonant");
			break;

		}

		sc.close();
	}

}
