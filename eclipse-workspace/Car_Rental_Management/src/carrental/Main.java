package carrental;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        // Login check
        if (!LoginService.login(user, pass)) {
            System.out.println("❌ Login failed!");
            return;
        }

        while (true) {

            System.out.println("\n🚗 Car Rental System");
            System.out.println("1. View Cars");
            System.out.println("2. Select Car");
            System.out.println("3. Generate Bill");
            System.out.println("4. Payment");
            System.out.println("5. Return Car");
            System.out.println("6. Exit");
        

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> CarService.viewCars();

                case 2 -> RentalService.rentCar(sc);

                case 3 -> BillingService.generateBill(sc);

                case 4 -> PaymentService.makePayment(sc);
                
                case 5 -> ReturnService.returnCar(sc);

                case 6 -> {
                    System.out.println("🔚 Goodbye!");
                    return;
                
                }

                default -> System.out.println("❌ Invalid option");
            }
        }
    }
}