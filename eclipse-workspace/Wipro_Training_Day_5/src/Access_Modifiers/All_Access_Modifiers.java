package Access_Modifiers;

class Value {
	public int publicVar = 10;
	private int privateVar = 20;
	protected int protectedVar = 30;
	int defaultVar = 40;

	public void showPublic() {
		System.out.println("Public Variable: " + publicVar);
	}

	private void showPrivate() {
		System.out.println("Private Variable: " + privateVar);
	}

	protected void showProtected() {
		System.out.println("Protected Variable: " + protectedVar);
	}

	void showDefault() {
		System.out.println("Default Variable: " + defaultVar);
	}

	public void accessPrivate() {
		showPrivate();
	}
}

public class All_Access_Modifiers {
	public static void main(String[] args) {
		Value obj = new Value();

		System.out.println("Public: " + obj.publicVar);
		System.out.println("Protected: " + obj.protectedVar);
		System.out.println("Default: " + obj.defaultVar);

		obj.showPublic();
		obj.showProtected();
		obj.showDefault();
		obj.accessPrivate();
	}
}