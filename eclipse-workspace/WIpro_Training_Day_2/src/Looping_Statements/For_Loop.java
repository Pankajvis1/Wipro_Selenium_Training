package Looping_Statements;

import java.util.Scanner;

public class For_Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number");
		int a = sc.nextInt();
		
		for(int i = 1; i<=a; i++)
		{
			System.out.println(i);
		}
		sc.close();
	}

}
