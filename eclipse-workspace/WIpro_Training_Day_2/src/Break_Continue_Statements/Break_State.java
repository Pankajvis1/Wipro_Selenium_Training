package Break_Continue_Statements;

public class Break_State {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i<=10; i++)
		{
			if(i==7 || i==9|| i==3|| i==4)
				//break;
				continue;
			
			System.out.println(i);
		}
	}

}
