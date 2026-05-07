package String_Practice;

public class string_Buffer {

	public static void main(String[] args) {
		
		//immutable String
		String str = "Java Selenium";
		System.out.println(str);
		
		//Convert Immutable String to mutable String
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb);
		
		//Convert mutable string to immutable String
		String str1=new String(sb);
	}

}
