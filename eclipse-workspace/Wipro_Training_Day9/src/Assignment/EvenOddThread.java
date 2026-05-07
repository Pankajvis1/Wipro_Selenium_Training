package Assignment;

class NumberPrinter {
	int num = 1;

	synchronized void printOdd() {
		while (num <= 100) {
			while (num % 2 == 0) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			if (num <= 100) {
				System.out.println("Odd: " + num);
				num++;
				notify();
			}
		}
	}

	synchronized void printEven() {
		while (num <= 100) {
			while (num % 2 != 0) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			if (num <= 100) {
				System.out.println("Even: " + num);
				num++;
				notify();
			}
		}
	}
}

public class EvenOddThread {
	public static void main(String[] args) {
		NumberPrinter obj = new NumberPrinter();

		Thread t1 = new Thread(() -> obj.printOdd());
		Thread t2 = new Thread(() -> obj.printEven());

		t1.start();
		t2.start();
	}
}