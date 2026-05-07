package Assignment;

import java.util.*;

public class SymmetricDifference {
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(40);

		HashSet<Integer> set2 = new HashSet<>();
		set2.add(30);
		set2.add(40);
		set2.add(50);
		set2.add(60);

		HashSet<Integer> union = new HashSet<>(set1);
		union.addAll(set2);

		HashSet<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);

		union.removeAll(intersection);

		System.out.println("Symmetric Difference: " + union);
	}
}