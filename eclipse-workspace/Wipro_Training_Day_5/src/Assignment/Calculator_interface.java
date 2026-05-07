package Assignment;

interface Calculator {
	void divide(int a, int b);
}

// Implementing the interface
class MyCalculator implements Calculator {
	@Override
	public void divide(int a, int b) {
		try {
			int result = a / b;
			System.out.println("Result: " + result);
		} catch (ArithmeticException e) {
			System.out.println("Error: Cannot divide by zero.");
		} finally {
			System.out.println("Operation attempted.");
		}
	}
}

public class Calculator_interface {
	public static void main(String[] args) {
		Calculator calc = new MyCalculator();

		calc.divide(10, 2); // Normal case
		calc.divide(10, 0); // Exception case
	}
}