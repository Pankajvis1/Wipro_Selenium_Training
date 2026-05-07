package Simple_Problems;

import java.util.Scanner;

public class Vowel_Consonant {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any character: ");
		char ch = sc.next().charAt(0);

		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
			System.out.println("This is a vowel " + ch);
		} else {
			System.out.println("This is a consonant " + ch);
		}

		sc.close();
	}

}
