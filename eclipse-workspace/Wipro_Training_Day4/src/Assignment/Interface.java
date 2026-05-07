package Assignment;

interface Movable {
	void moveUp();

	void moveDown();

	void moveLeft();

	void moveRight();
}

class MovablePoint implements Movable {
	int x, y;
	int xSpeed, ySpeed;

	MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public void moveUp() {
		y = y + ySpeed;
	}

	public void moveDown() {
		y = y - ySpeed;
	}

	public void moveLeft() {
		x = x - xSpeed;
	}

	public void moveRight() {
		x = x + xSpeed;
	}

	public String toString() {
		return "Point (" + x + ", " + y + ")";
	}
}

class MovableCircle implements Movable {
	int radius;
	MovablePoint center;

	MovableCircle(int radius, MovablePoint center) {
		this.radius = radius;
		this.center = center;
	}

	public void moveUp() {
		center.moveUp();
	}

	public void moveDown() {
		center.moveDown();
	}

	public void moveLeft() {
		center.moveLeft();
	}

	public void moveRight() {
		center.moveRight();
	}

	public String toString() {
		return "Circle [Radius=" + radius + ", Center=" + center + "]";
	}
}

class MovableRectangle implements Movable {
	MovablePoint topLeft;
	MovablePoint bottomRight;

	MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
		if (topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed) {
			this.topLeft = topLeft;
			this.bottomRight = bottomRight;
		} else {
			System.out.println("Both points must have same speed!");
		}
	}

	public void moveUp() {
		topLeft.moveUp();
		bottomRight.moveUp();
	}

	public void moveDown() {
		topLeft.moveDown();
		bottomRight.moveDown();
	}

	public void moveLeft() {
		topLeft.moveLeft();
		bottomRight.moveLeft();
	}

	public void moveRight() {
		topLeft.moveRight();
		bottomRight.moveRight();
	}

	public String toString() {
		return "Rectangle [TopLeft=" + topLeft + ", BottomRight=" + bottomRight + "]";
	}
}

public class Interface {
	public static void main(String[] args) {
		
		MovablePoint p1 = new MovablePoint(2, 3, 1, 1);
		System.out.println(p1);

		p1.moveUp();
		p1.moveRight();
		System.out.println("After moving: " + p1);

		MovableCircle c1 = new MovableCircle(5, new MovablePoint(10, 10, 2, 2));

		System.out.println(c1);

		c1.moveLeft();
		c1.moveDown();
		System.out.println("After moving: " + c1);

		MovableRectangle r1 = new MovableRectangle(new MovablePoint(0, 10, 1, 1), new MovablePoint(5, 5, 1, 1));

		System.out.println(r1);

		r1.moveRight();
		r1.moveDown();
		System.out.println("After moving: " + r1);
	}
}