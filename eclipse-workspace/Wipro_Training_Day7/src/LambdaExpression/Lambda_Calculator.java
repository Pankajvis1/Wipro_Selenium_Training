package LambdaExpression;

interface Calculator {
	int calculate(int a, int b);
}

public class Lambda_Calculator {
	public static void main(String[] args) {

		Calculator add = (a, b) -> a + b;
		System.out.println("Addition: " + add.calculate(10, 5));

		Calculator sub = (a, b) -> a - b;
		System.out.println("Subtraction: " + sub.calculate(10, 5));

		Calculator multiply = (a, b) -> a * b;
		System.out.println("Multiplication: " + multiply.calculate(10, 5));

		Calculator divide = (a, b) -> a / b;
		System.out.println("Division: " + divide.calculate(10, 5));
	}
}