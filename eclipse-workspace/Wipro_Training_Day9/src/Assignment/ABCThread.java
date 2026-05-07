package Assignment;

class ABCPrinter {
	int turn = 1;

	synchronized void printA() {
		for (int i = 0; i < 5; i++) {
			while (turn != 1) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			System.out.print("A ");
			turn = 2;
			notifyAll();
		}
	}

	synchronized void printB() {
		for (int i = 0; i < 5; i++) {
			while (turn != 2) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			System.out.print("B ");
			turn = 3;
			notifyAll();
		}
	}

	synchronized void printC() {
		for (int i = 0; i < 5; i++) {
			while (turn != 3) {
				try {
					wait();
				} catch (Exception e) {
				}
			}
			System.out.print("C ");
			turn = 1;
			notifyAll();
		}
	}
}

public class ABCThread {
	public static void main(String[] args) {
		ABCPrinter obj = new ABCPrinter();

		Thread t1 = new Thread(() -> obj.printA());
		Thread t2 = new Thread(() -> obj.printB());
		Thread t3 = new Thread(() -> obj.printC());

		t1.start();
		t2.start();
		t3.start();
	}
}