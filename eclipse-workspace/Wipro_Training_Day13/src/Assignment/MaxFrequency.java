package Assignment;

import java.util.HashMap;

public class MaxFrequency {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 2, 4, 2, 5, 1, 1, 1 };

		HashMap<Integer, Integer> map = new HashMap<>();

		// Count frequency
		for (int num : arr) {

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		int maxFreq = 0;
		int element = 0;

		// Find maximum frequency element
		for (int key : map.keySet()) {

			if (map.get(key) > maxFreq) {
				maxFreq = map.get(key);
				element = key;
			}
		}

		System.out.println("Element with maximum frequency: " + element);
		System.out.println("Frequency: " + maxFreq);
	}
}