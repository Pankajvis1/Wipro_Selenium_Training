package Simple_Problems;

import java.util.Scanner;

public class Eligiblity_For_Loan {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter age: ");
		int age = sc.nextInt();

		System.out.print("Enter salary: ");
		int salary = sc.nextInt();

		if (age >= 18 && salary >= 25000) {
			System.out.println("Eligible for loan");

		} else {
			System.out.println("Not Eligible for loan");

		}

		sc.close();

	}

}
