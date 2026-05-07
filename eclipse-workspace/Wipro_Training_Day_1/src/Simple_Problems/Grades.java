package Simple_Problems;

import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter percentage: ");
		int per = sc.nextInt();
		
		if (per >= 70 && per < 80 )
		{
			System.out.println("Passed with Distinction");
			
		}
			else if(per >= 80 && per < 90)
		{
			System.out.println("Passed with Distinction and A+" );
			
		}
			else if (per >= 90 && per < 95)
		{
			System.out.println("Passed with Distinction and A++");
		}
			
			else if(per >= 95)
		{
				System.out.println("Passed with Distinction and A+++");
		}
			else {
				System.out.println("Fail");
			}
		
		sc.close();
	}

}

