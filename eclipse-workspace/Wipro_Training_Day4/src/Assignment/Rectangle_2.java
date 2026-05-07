package Assignment;

interface Polygon {
	double getArea();

	default double getPerimeter(int... sides) {
		int sum = 0;
		for (int side : sides) {
			sum = sum + side;
		}
		return sum;
	}

	static String shapeInfo() {
		return "Polygon is a closed shape with multiple sides.";
	}
}

class Rectangle implements Polygon {
	int length, width;

	Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public double getArea() {
		return length * width;
	}
}

class Triangle implements Polygon {
	int base, height;

	Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	public double getArea() {
		return 0.5 * base * height;
	}
}

public class Rectangle_2 {
	public static void main(String[] args) {

		Rectangle r = new Rectangle(10, 5);
		System.out.println("Rectangle Area: " + r.getArea());
		System.out.println("Rectangle Perimeter: " + r.getPerimeter(10, 5, 10, 5));

		Triangle t = new Triangle(8, 6);
		System.out.println("Triangle Area: " + t.getArea());
		System.out.println("Triangle Perimeter: " + t.getPerimeter(8, 7, 6));

		System.out.println(Polygon.shapeInfo());
	}
}