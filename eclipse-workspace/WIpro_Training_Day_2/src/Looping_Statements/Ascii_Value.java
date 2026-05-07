package Looping_Statements;

import java.util.Scanner;

public class Ascii_Value{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a capital letter: ");
        char ch = sc.next().charAt(0);

        for (int i = 1; i <= 1; i++) { 
            System.out.println("ASCII value of " + ch + " is: " + (int) ch);
        }

        sc.close();
    }
}