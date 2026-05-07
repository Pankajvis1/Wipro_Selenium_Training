package Exception_Handling;

import java.util.*;

public class throws_exception {



		public static void main(String[] args)   throws InterruptedException {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter any number:");

			int a = scanner.nextInt();
			int b = 88;
			
			Thread.sleep(100);
			try {

				int c = b / a;

				System.out.println("Division =" + c);

			}

			catch (ArithmeticException e) {
				System.out.println(e);

			}

			finally {

				System.out.println("Passs the level");

			}
			scanner.close();
		}

	}