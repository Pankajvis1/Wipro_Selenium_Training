package Assignment;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};

        // Ascending Order
        Arrays.sort(arr);
        System.out.println("Ascending Order:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // Descending Order
        System.out.println("\nDescending Order:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}