package Assignment_Day_2;

import java.util.Scanner;

public class CurrencyConvertor {

    public static void main(String[] args) {

        int USD = 90;
        int EUR = 100;
        int YEN = 20;

        double value;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter choice for currency conversion (1.INR to USD, 2.INR to EUR, 3.INR to YEN): ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter amount in INR: ");
                int inr1 = sc.nextInt();
                value = (double) inr1 / USD;
                System.out.println("Converted value in USD = " + value);
                break;

            case 2:
                System.out.print("Enter amount in INR: ");
                int inr2 = sc.nextInt();
                value = (double) inr2 / EUR;
                System.out.println("Converted value in EUR = " + value);
                break;

            case 3:
                System.out.print("Enter amount in INR: ");
                int inr3 = sc.nextInt();
                value = (double) inr3 / YEN;
                System.out.println("Converted value in YEN = " + value);
                break;

            default:
                System.out.println("Invalid Input");
        }

        sc.close();
    }
}