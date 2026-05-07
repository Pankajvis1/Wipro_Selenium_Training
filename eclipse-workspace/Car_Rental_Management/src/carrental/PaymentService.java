package carrental;

import java.util.Scanner;

public class PaymentService {

	public static void makePayment(Scanner sc) {

		System.out.println("\n💳 Payment Methods");
		System.out.println("1. Cash");
		System.out.println("2. Credit Card");
		System.out.println("3. UPI");
		System.out.println("4. Net Banking");

		System.out.print("Choose payment method: ");
		int option = sc.nextInt();
		sc.nextLine();

		switch (option) {

		// Cash Payment
		case 1 -> {

			System.out.print("Enter amount status (paid/not paid): ");
			String status = sc.nextLine();

			if (status.equalsIgnoreCase("paid")) {

				System.out.println("✅ Cash payment selected");
				System.out.println("✅ Payment Successful");

			} else {

				System.out.println("❌ Payment Failed");
			}
		}

		// Credit Card Payment
		case 2 -> {

			System.out.print("Enter Card Number: ");
			String card = sc.nextLine();

			System.out.print("Enter CVV: ");
			String cvv = sc.nextLine();

			if (card.length() == 16 && cvv.length() == 3) {

				System.out.println("✅ Credit Card payment selected");
				System.out.println("✅ Payment Successful");

			} else {

				System.out.println("❌ Invalid Card Details");
			}
		}

		// UPI Payment
		case 3 -> {

			System.out.print("Enter UPI ID: ");
			String upi = sc.nextLine();

			if (upi.contains("@")) {

				System.out.println("✅ UPI payment selected");
				System.out.println("✅ Payment Successful");

			} else {

				System.out.println("❌ Invalid UPI ID");
			}
		}

		// Net Banking
		case 4 -> {

			System.out.print("Enter Bank Name: ");
			String bank = sc.nextLine();

			if (!bank.isEmpty()) {

				System.out.println("✅ Net Banking selected");
				System.out.println("✅ Payment Successful");

			} else {

				System.out.println("❌ Invalid Bank Name");
			}
		}

		default -> {

			System.out.println("❌ Invalid payment option");
		}
		}
	}
}