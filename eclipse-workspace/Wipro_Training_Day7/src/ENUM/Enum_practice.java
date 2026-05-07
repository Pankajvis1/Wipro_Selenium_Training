package ENUM;

public class Enum_practice {


	enum Day {
	    SUNDAY,
	    MONDAY,
	    TUESDAY,
	    WEDNESDAY,
	    THURSDAY,
	    FRIDAY,
	    SATURDAY
	}

	public class Test {
	    public static void main(String[] args) {
	        
	        Day day = Day.WEDNESDAY;

	        switch (day) {
	            case MONDAY:
	                System.out.println("Today is Monday");
	                break;

	            case TUESDAY:
	                System.out.println("Today is Tuesday");
	                break;

	            case WEDNESDAY:
	                System.out.println("Today is WEDNESDAY");
	                break;

	            case THURSDAY:
	                System.out.println("Today is THURSDAY");
	                break;

	            case FRIDAY:
	                System.out.println("Today is FRIDAY");
	                break;

	            case SATURDAY:
	                System.out.println("Today is SATURDAY");
	                break;

	            case SUNDAY:
	                System.out.println("Today is SUNDAY");
	                break;
	                
	        }
	    }
	}
}