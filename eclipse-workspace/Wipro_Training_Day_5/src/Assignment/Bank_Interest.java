package Assignment;

	// Abstract class
	abstract class Bank {
	    // Abstract method
	    abstract double getInterestRate();
	}

	class SBI extends Bank {
	    
	    double getInterestRate() {
	        return 6.5;
	    }
	}

	class HDFC extends Bank {
	    
	    double getInterestRate() {
	        return 7.2;
	    }
	}

	class ICICI extends Bank {
	   
	    double getInterestRate() {
	        return 6.8;
	    }
	}

	public class Bank_Interest {
	    public static void main(String[] args) {
	        Bank b1 = new SBI();
	        Bank b2 = new HDFC();
	        Bank b3 = new ICICI();

	        System.out.println("SBI Interest Rate: " + b1.getInterestRate() + "%");
	        System.out.println("HDFC Interest Rate: " + b2.getInterestRate() + "%");
	        System.out.println("ICICI Interest Rate: " + b3.getInterestRate() + "%");
	    }
	}
