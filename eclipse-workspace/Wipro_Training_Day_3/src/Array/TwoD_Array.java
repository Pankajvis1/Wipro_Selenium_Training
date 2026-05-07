package Array;

public class TwoD_Array {


	    public static void main(String[] args) {

	        int[][] a = {
	            {10},
	            {20, 40},
	            {50, 60, 70},
	            {90, 80, 70, 60}
	        };

	        for (int i = 0; i < a.length; i++) {

	            for (int j = 0; j < a[i].length; j++) {

	                System.out.print(a[i][j] + " ");
	            }

	            System.out.println();
	        }
	    }
	}