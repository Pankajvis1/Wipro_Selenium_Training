package Simple_Problems;
import java.util.Scanner;


public class Check_Positive_Negative {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any positive or negative number: ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("This is a positive num");
		}	
		else if (num < 0 ) {
			
			System.out.println("This is a negative num");	
		
		}
		sc.close();

	}

}
