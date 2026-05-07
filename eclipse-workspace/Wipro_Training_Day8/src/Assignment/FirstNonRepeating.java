package Assignment;

import java.util.*;

public class FirstNonRepeating {
	public static void main(String[] args) {
		String str = "programming";

		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : str.toCharArray()) {
			if (map.get(ch) == 1) {
				System.out.println("First Non-Repeating Character: " + ch);
				break;
			}
		}
	}
}