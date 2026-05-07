package Array;

	
	public class Single_array {
	 
		public static void main(String[] args) {
//			int[] arr= {98,78,99,66};// length=5 last index=4// dynamic array
//			int[] ar=new int[5];// static array
//			//index     0 1 2 3 4
//			//System.out.println(arr[4]);
//			for(int i=0;i<arr.length;i++)
//			{
//				System.out.print(arr[i]+"   ");
//			}
			
			int[][] a= {{20, 40},// row0=i
					    {50, 60,70},
					    {90,80,70,60}};//row1=j
			//System.out.println(a[1][1]);
			for(int i=0;i<a.length;i++)
			{
				for(int j=0;j<a[i].length;j++)
				{
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
	 
		}
	 
	}
	//1
	//1 2
	//1 2 3
	//1 2 3 4
	 