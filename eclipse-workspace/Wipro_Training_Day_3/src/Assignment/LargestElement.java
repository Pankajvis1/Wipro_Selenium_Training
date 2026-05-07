package Assignment;

public class LargestElement {


	public static void main(String[] args) {
		int[][] arr = {
				{10, 25, 3},
				{45, 12, 8},
				{7, 90, 15}
		};

		for (int i = 0; i < arr.length; i++) {
			int largest = arr[i][0];

			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] > largest) {
					largest = arr[i][j];
				}
			}

			System.out.println("Largest element in row " + (i + 1) + " = " + largest);
		}
	}
}