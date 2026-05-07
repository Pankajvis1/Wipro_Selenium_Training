package Assignment;

public class Rotate_Array {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Matrix after 90 degree rotation:");

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = matrix.length - 1; j >= 0; j--) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}
}