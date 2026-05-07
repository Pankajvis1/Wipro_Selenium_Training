package Assignment;

import java.util.*;

public class CommonElements {
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

        set1.retainAll(set2);

        System.out.println("Common Elements: " + set1);
    }
}