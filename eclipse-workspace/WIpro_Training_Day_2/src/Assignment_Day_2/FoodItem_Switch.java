package Assignment_Day_2;

import java.util.Scanner;

public class FoodItem_Switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter food item number (1-5): ");
		int num = sc.nextInt();

		switch (num) {

		case 1:
			System.out.println("Rice");
			break;

		case 2:
			System.out.println("Wheet");
			break;

		case 3:
			System.out.println("Milk");
			break;

		case 4:
			System.out.println("Pulse");
			break;

		case 5:
			System.out.println("Cookies");
			break;

		default:
			System.out.println("Invalid Input");
			break;
		}

		sc.close();
	}

}

/*
 * Create a program where user selects food item number and the program displays
 * item name and price.
 */