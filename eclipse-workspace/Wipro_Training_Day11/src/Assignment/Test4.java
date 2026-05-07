package Assignment;

import java.util.*;

public class Test4 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(3, "C");
		map.put(1, "A");
		map.put(2, "B");

		// Sorting by keys
		TreeMap<Integer, String> sortedMap = new TreeMap<>(map);

		System.out.println(sortedMap);
	}
}