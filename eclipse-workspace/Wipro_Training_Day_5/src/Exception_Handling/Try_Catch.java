package Exception_Handling;

import java.util.Scanner;

public class Try_Catch {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number:");
		
		int a = scanner.nextInt();
		int b = 88;
		
		try {
			int c = b/a ; 
			
			System.out.println("Division =" +c);
			

		}
		
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		System.out.println("End");
		
		scanner.close();
	}

}
