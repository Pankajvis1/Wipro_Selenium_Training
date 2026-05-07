package Assignment;

import java.util.*;

public class Test {
	public static void main(String[] args) {

		String str = "aabbcdeff";

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : str.toCharArray()) {
			if (map.get(ch) == 1) {
				System.out.println("First non-repeating character: " + ch);
				return;
			}
		}

		System.out.println("No non-repeating character");
	}
}