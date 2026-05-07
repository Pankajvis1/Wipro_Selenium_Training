package Assignment;

public class Question_3to7 {

		public static void main(String[] args) {

			// 3. Check if character is a digit
		char ch = '7';
		if (Character.isDigit(ch)) {
			System.out.println(ch + " is a digit");
		} else {
			System.out.println(ch + " is not a digit");
		}

		// 4. Compare two Strings
		String s1 = "Java";
		String s2 = "java";

		System.out.println("Using equals(): " + s1.equals(s2));
		System.out.println("Using equalsIgnoreCase(): " 
		+ s1.equalsIgnoreCase(s2));

		// 5. Convert using valueOf method
		int num = 50;
		String str = String.valueOf(num);
		System.out.println("Converted int to String: " + str);

		double d = 12.34;
		String str2 = String.valueOf(d);
		System.out.println("Converted double to String: " + str2);

		// 6. Boolean Wrapper usage
		Boolean b1 = Boolean.valueOf("true");
		Boolean b2 = Boolean.FALSE;

		System.out.println("Boolean b1: " + b1);
		System.out.println("Boolean b2: " + b2);

		// 7. Convert null to wrapper classes
		String nullStr = null;

		try {
			Integer i = Integer.valueOf(nullStr);
			System.out.println("Converted value: " + i);
		} catch (Exception e) {
			System.out.println("Exception while converting null String: " + e);
		}

		// Wrapper holding null
		Integer numObj = null;
		System.out.println("Integer object holding null: " + numObj);
	}
}

