package Assignment;

class Box {
	int length;

	Box(int length) {
		this.length = length;
	}
}

public class Question_2 {

	// Method to modify Box object
	static void modifyBox(Box b) {
		System.out.println("Inside method (before change): " + b.length);
		b.length = b.length + 10;
		System.out.println("Inside method (after change): " + b.length);
	}

	public static void main(String[] args) {
		Box box = new Box(5);

		System.out.println("Before method call: " + box.length);
		modifyBox(box);
		System.out.println("After method call: " + box.length);
	}
}