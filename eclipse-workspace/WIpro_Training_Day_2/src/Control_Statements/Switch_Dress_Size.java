package Control_Statements;
import java.util.Scanner;

public class Switch_Dress_Size {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: "); 
        int size = sc.nextInt();
        
		switch(size)
		{
		
		case 26 : System.out.println("26 → Extra Small (XS)");
		break;
		case 28 : System.out.println("28 → Small (S)");
		break;
		case 30 : System.out.println("30 → Medium (M");
		break;
		case 32 : System.out.println("32 → Large (L)");
		break;
		case 34 : System.out.println("34 → Extra Large (XL)");
		break;
		default : System.out.println("Invalid size");
		
		
		}
		sc.close();
	}

}
