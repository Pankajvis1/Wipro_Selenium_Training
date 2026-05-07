package Array;

public class ThreeD_Array {

	
	
	 
		public static void main(String[] args) {
			int[][][] arr= {{{10,20},{30,40}},//ref0
					       {{50,60,70},{80,90}}};//ref1
			
			//System.out.println(arr[1][0][2]);
			for(int i=0;i<arr.length;i++)// ref
			{
				for(int j=0;j<arr[i].length;j++)
				{
					for(int k=0;k<arr[i][j].length;k++)
					{
						System.out.print(arr[i][j][k]+"   ");
					}
					System.out.println();
				}
				System.out.println();
			}
	 
		}
	 
	}
	 