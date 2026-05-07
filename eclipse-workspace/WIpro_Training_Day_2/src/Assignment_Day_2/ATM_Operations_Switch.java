package Assignment_Day_2;
import java.util.Scanner;

public class ATM_Operations_Switch {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 2000000;

        System.out.print("Enter any choice (1.Check Balance, 2.Deposit, 3.Withdraw, 4.Exit): ");
        String choice = sc.next();

        switch (choice) {

            case "1":
                System.out.println("Balance = " + balance);
                break;

            case "2":
                System.out.print("Enter amount to Deposit: ");
                int amount = sc.nextInt();
                balance = balance + amount;
                System.out.println("Updated Balance = " + balance);
                break;

            case "3":
                System.out.print("Enter amount to Withdraw: ");
                int withdraw = sc.nextInt();
                balance = balance - withdraw;
                System.out.println("Updated Balance = " + balance);
                break;

            case "4":
                System.out.println("Thank you for using ATM");
                break;

            default:
                System.out.println("Invalid Input");
        }

        sc.close();
    }
}
/*4. Create a menu-driven program for ATM operations: 
• 1 → Check Balance 
• 2 → Deposit 
• 3 → Withdraw 
• 4 → Exit 
   Perform the operation based on user choice */
