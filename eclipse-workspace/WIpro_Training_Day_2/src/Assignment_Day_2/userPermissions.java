package Assignment_Day_2;

import java.util.Scanner;

public class userPermissions {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter your choice (1.Admin, 2.User, 3.Guest): ");
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("Admin Permissions: Read, Write, View");
			break;

		case 2:
			System.out.println("User Permissions: Read, View");
			break;

		case 3:
			System.out.println("Guest Permissions: View");
			break;

		default:
			System.out.println("Invalid Input");
		}

		sc.close();
	}
}