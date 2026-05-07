package String;

public class String_test {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		
	String str= "Hellojghuii,juugo" ;
	String str1= "welcomeWelcome";
	
	System.out.println(str);
	System.out.println(str.charAt(1));
	System.out.println(str.indexOf('L'));
	System.out.println(str.codePointAt(2));
	System.out.println(str.codePointBefore(1));
	System.out.println(str1.compareTo(str));
	System.out.println(str.compareToIgnoreCase(str1));
	System.out.println(str.concat(" Nisha"));
	
	//str = str.concat(" Nisha");
	System.out.println(str);
	System.out.println(str1.contains("come"));
	System.out.println(str.equals(str1));
	System.out.println(str.equalsIgnoreCase(str1));
	System.out.println(str1.isBlank());
	System.out.println(str1.isEmpty());
	System.out.println(str.lastIndexOf('o')); //for char
	System.out.println(str1.lastIndexOf("come")); // for string value
	}

}
