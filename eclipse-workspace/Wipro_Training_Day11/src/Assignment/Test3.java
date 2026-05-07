package Assignment;

import java.util.*;

public class Test3 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 1, 4, 1, 3, 3, 3 };

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int maxFreq = 0;
		int maxElement = -1;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxFreq) {
				maxFreq = entry.getValue();
				maxElement = entry.getKey();
			}
		}

		System.out.println("Element: " + maxElement);
		System.out.println("Frequency: " + maxFreq);
	}
}